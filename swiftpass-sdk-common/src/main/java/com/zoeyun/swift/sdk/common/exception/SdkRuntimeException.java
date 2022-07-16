package com.zoeyun.swift.sdk.common.exception;

public class SdkRuntimeException extends RuntimeException {

    public SdkRuntimeException(Throwable e) {
        super(e);
    }

    public SdkRuntimeException(String msg) {
        super(msg);
    }

    public SdkRuntimeException(String msg, Throwable e) {
        super(msg, e);
    }
}

