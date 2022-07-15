package com.zoeyun.swift.sdk.common.exception;

public class PayRuntimeException extends RuntimeException {

    public PayRuntimeException(Throwable e) {
        super(e);
    }

    public PayRuntimeException(String msg) {
        super(msg);
    }

    public PayRuntimeException(String msg, Throwable e) {
        super(msg, e);
    }
}

