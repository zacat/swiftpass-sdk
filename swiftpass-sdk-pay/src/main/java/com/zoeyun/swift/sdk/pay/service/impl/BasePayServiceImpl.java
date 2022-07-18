package com.zoeyun.swift.sdk.pay.service.impl;

import com.zoeyun.swift.sdk.pay.config.PayConfig;
import com.zoeyun.swift.sdk.pay.service.MicroPayService;
import com.zoeyun.swift.sdk.pay.service.PayService;
import com.zoeyun.swift.sdk.pay.service.UnifiedPayService;
import com.zoeyun.swift.sdk.pay.service.WxWapPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePayServiceImpl implements PayService {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    PayConfig payConfig;


    WxWapPayService wxWapPayService = new WxWapPayServiceImpl(this);
    MicroPayService microPayService = new MicroPayServiceImpl(this);
    UnifiedPayService unifiedPayService = new UnifiedPayServiceImpl(this);

    @Override
    public String getPayBaseUrl() {
        if (payConfig == null) {
            throw new RuntimeException("支付配置");
        }

        return payConfig.getPayBaseUrl();
    }

    @Override
    public PayConfig getConfig() {
        return payConfig;
    }

    @Override
    public void setConfig(PayConfig config) {
        payConfig = config;
    }

    @Override
    public WxWapPayService getWxWapPayService() {
        return wxWapPayService;
    }

    @Override
    public MicroPayService getMicroPayService() {
        return microPayService;
    }

    @Override
    public UnifiedPayService getUnifiedPayService() {
        return unifiedPayService;
    }
}
