package com.zoeyun.swift.sdk.pay.constant;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.Format;
import java.util.List;

public class PayConstants {


    /**
     * 拉取订单评价数据接口的参数中日期格式.
     */
    public static final Format QUERY_COMMENT_DATE_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss");


    /**
     * 签名类型.
     */
    public static class SignType {
        /**
         * The constant HMAC_SHA256.
         */
        public static final String RSA256 = "RSA_1_256";
        /**
         * The constant MD5.
         */
        public static final String RSA = "RSA_1_1";
        /**
         * The constant ALL_SIGN_TYPES.
         */
        public static final List<String> ALL_SIGN_TYPES = Lists.newArrayList(RSA256, RSA);
    }

    /**
     * 业务结果代码.
     */
    public static class ResultCode {
        /**
         * 成功.
         */
        public static final String SUCCESS = "0";

        /**
         * 失败.
         */
        public static final String FAIL = "1";
    }
}
