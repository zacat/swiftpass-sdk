package com.zoeyun.swift.sdk.pay.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.pay.bean.BasePayRequest;
import com.zoeyun.swift.sdk.pay.bean.BasePayResult;
import com.zoeyun.swift.sdk.pay.constant.PayConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.*;


@Slf4j
public class SignUtils {
    /**
     * 签名的时候不携带的参数
     */
    private static final List<String> NO_SIGN_PARAMS = Lists.newArrayList("sign", "key", "xmlString", "xmlDoc", "couponList");

    /**
     * 请参考并使用 {@link #createSign(Object, String, String, String[])}.
     *
     * @param xmlBean   the xml bean
     * @param rsaPriKey the sign key
     * @return the string
     */
    @Deprecated
    public static String createSign(Object xmlBean, String rsaPriKey) {
        return createSign(xmlBean2Map(xmlBean), rsaPriKey);
    }

    /**
     * 请参考并使用 {@link #createSign(Map, String, String, String[])} .
     *
     * @param params    the params
     * @param rsaPriKey the sign key
     * @return the string
     */
    @Deprecated
    public static String createSign(Map<String, String> params, String rsaPriKey) {
        return createSign(params, PayConstants.SignType.RSA256, rsaPriKey, new String[0]);
    }

    /**
     * 微信支付签名算法(详见:https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3).
     *
     * @param xmlBean       Bean里的属性如果存在XML注解，则使用其作为key，否则使用变量名
     * @param signType      签名类型，如果为空，则默认为MD5
     * @param rsaPriKey     签名Key
     * @param ignoredParams 签名时需要忽略的特殊参数
     * @return 签名字符串 string
     */
    public static String createSign(Object xmlBean, String signType, String rsaPriKey, String[] ignoredParams) {
        Map<String, String> map = null;

        if (XmlConfig.fastMode) {
            if (xmlBean instanceof BasePayRequest) {
                map = ((BasePayRequest) xmlBean).getSignParams();
            }
        }
        if (map == null) {
            map = xmlBean2Map(xmlBean);
        }

        return createSign(map, signType, rsaPriKey, ignoredParams);
    }

    /**
     * 微信支付签名算法(详见:https://pay.weixin.qq.com/wiki/doc/api/tools/cash_coupon.php?chapter=4_3).
     *
     * @param params        参数信息
     * @param signType      签名类型，如果为空，则默认为MD5
     * @param rsaPriKey     签名Key
     * @param ignoredParams 签名时需要忽略的特殊参数
     * @return 签名字符串 string
     */
    public static String createSign(Map<String, String> params, String signType, String rsaPriKey, String[] ignoredParams) {
        StringBuilder toSign = new StringBuilder();
        for (String key : new TreeMap<>(params).keySet()) {
            String value = params.get(key);
            boolean shouldSign = false;
            if (StringUtils.isNotEmpty(value) && !ArrayUtils.contains(ignoredParams, key)
                    && !NO_SIGN_PARAMS.contains(key)) {
                shouldSign = true;
            }
            if (shouldSign) {
                toSign.append(key).append("=").append(value).append("&");
            }
        }
        toSign.setLength(toSign.length() - 1);
        RSAUtils.SignatureSuite suite = null;
        if ("RSA_1_1".equals(signType)) {
            suite = RSAUtils.SignatureSuite.SHA1;
        } else if ("RSA_1_256".equals(signType)) {
            suite = RSAUtils.SignatureSuite.SHA256;
        }
        byte[] signBuf = RSAUtils.sign(suite, toSign.toString().getBytes(StandardCharsets.UTF_8),
                rsaPriKey);

        return new String(Base64.encodeBase64(signBuf), StandardCharsets.UTF_8);
    }

    /**
     * 校验签名是否正确.
     *
     * @param xmlBean  Bean需要标记有XML注解
     * @param signType 签名类型，如果为空，则默认为MD5
     * @param signKey  校验的签名Key
     * @return true - 签名校验成功，false - 签名校验失败
     */
    public static boolean checkSign(Object xmlBean, String signType, String signKey) {
        return checkSign(xmlBean2Map(xmlBean), signType, signKey);
    }

    /**
     * 校验签名是否正确.
     *
     * @param params    需要校验的参数Map
     * @param signType  签名类型，如果为空，则默认为MD5
     * @param rsaPubKey 校验的签名Key
     * @return true - 签名校验成功，false - 签名校验失败
     */
    public static boolean checkSign(Map<String, String> params, String signType, String rsaPubKey) {
        String sign = params.get("sign");
        StringBuilder toSign = new StringBuilder();
        for (String key : new TreeMap<>(params).keySet()) {
            String value = params.get(key);
            boolean shouldSign = false;
            if (StringUtils.isNotEmpty(value)
                    && !NO_SIGN_PARAMS.contains(key)) {
                shouldSign = true;
            }
            if (shouldSign) {
                toSign.append(key).append("=").append(value).append("&");
            }
        }
        toSign.setLength(toSign.length() - 1);
        RSAUtils.SignatureSuite suite = null;

        if ("RSA_1_1".equals(signType)) {
            suite = RSAUtils.SignatureSuite.SHA1;
        } else if ("RSA_1_256".equals(signType)) {
            suite = RSAUtils.SignatureSuite.SHA256;
        }

        return RSAUtils.verifySign(suite, toSign.toString().getBytes(StandardCharsets.UTF_8),
                Base64.decodeBase64(sign.getBytes(StandardCharsets.UTF_8)),
                rsaPubKey);
    }

    /**
     * 将bean按照@XStreamAlias标识的字符串内容生成以之为key的map对象.
     *
     * @param bean 包含@XStreamAlias的xml bean对象
     * @return map对象 map
     */
    public static Map<String, String> xmlBean2Map(Object bean) {
        Map<String, String> result = Maps.newHashMap();
        List<Field> fields = new ArrayList<>(Arrays.asList(bean.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));
        if (bean.getClass().getSuperclass().getSuperclass() == BasePayRequest.class) {
            fields.addAll(Arrays.asList(BasePayRequest.class.getDeclaredFields()));
        }

        if (bean.getClass().getSuperclass().getSuperclass() == BasePayResult.class) {
            fields.addAll(Arrays.asList(BasePayResult.class.getDeclaredFields()));
        }

        for (Field field : fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.get(bean) == null) {
                    field.setAccessible(isAccessible);
                    continue;
                }

                if (field.isAnnotationPresent(XStreamAlias.class)) {
                    result.put(field.getAnnotation(XStreamAlias.class).value(), field.get(bean).toString());
                } else if (!Modifier.isStatic(field.getModifiers())) {
                    //忽略掉静态成员变量
                    result.put(field.getName(), field.get(bean).toString());
                }

                field.setAccessible(isAccessible);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }

        }

        return result;
    }
}