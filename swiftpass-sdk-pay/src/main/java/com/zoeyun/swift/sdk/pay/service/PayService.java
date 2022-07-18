package com.zoeyun.swift.sdk.pay.service;

import com.zoeyun.swift.sdk.pay.config.PayConfig;
import com.zoeyun.swift.sdk.pay.exception.PayException;

public interface PayService {

    /**
     * 获取支付请求url前缀，沙箱环境可能不一样.
     *
     * @return the pay base url
     */
    String getPayBaseUrl();

    /**
     * 获取配置.
     *
     * @return the config
     */
    PayConfig getConfig();

    /**
     * 设置配置对象.
     *
     * @param config the config
     */
    void setConfig(PayConfig config);

    /**
     * 发送post请求，得到响应字节数组.
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字节数组 byte [ ]
     * @throws PayException the wx pay exception
     */
    byte[] postForBytes(String url, String requestStr) throws PayException;

    /**
     * 发送post请求，得到响应字符串.
     *
     * @param url        请求地址
     * @param requestStr 请求信息
     * @return 返回请求结果字符串 string
     * @throws PayException the wx pay exception
     */
    String post(String url, String requestStr) throws PayException;


    /**
     * 微信WAP支付功能
     *
     * @return
     */
    WxWapPayService getWxWapPayService();

    /**
     * 微信APP支付功能
     *
     * @return
     */
    WxAppPayService getWxAppPaySercice();

    /**
     * 统一付款码支付功能
     *
     * @return
     */
    MicroPayService getMicroPayService();

    /**
     * 统一付扫码支付功能
     *
     * @return
     */
    UnifiedPayService getUnifiedPayService();
}
