package com.zoeyun.swift.sdk.pay.config.impl;

import com.zoeyun.swift.sdk.pay.config.PayConfig;
import lombok.Data;

import java.io.Serializable;

@Data
public class DefaultPayConfigImpl implements PayConfig, Serializable {

    private static final String DEFAULT_PAY_BASE_URL = "https://faas.mypays.cn";
    private static final String DEFAULT_SANDBOX_PAY_BASE_URL = "http://test.mypays.cn";

    protected volatile String appId;
    protected volatile String mchId;
    protected volatile String rsaPriKey;
    protected volatile String rsaPubKey;
    protected volatile String signType;
    protected volatile int httpConnectionTimeout = 5000;
    private int httpTimeout = 10000;
    private boolean useSandboxEnv = false;

    @Override
    public Boolean getUseSandboxEnv() {
        return useSandboxEnv;
    }

    @Override
    public String getPayBaseUrl() {
        if (useSandboxEnv) {
            return DEFAULT_SANDBOX_PAY_BASE_URL;
        }
        return DEFAULT_PAY_BASE_URL;
    }
}
