package com.zoeyun.swift.sdk.pay.config;

public interface PayConfig {

    String getAppId();

    String getMchId();

    String getRsaPubKey();

    String getRsaPriKey();

    Boolean getUseSandboxEnv();

    String getPayBaseUrl();

    String getSignType();

    int getHttpConnectionTimeout();

    int getHttpTimeout();

}
