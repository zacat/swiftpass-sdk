package com.zoeyun.swift.sdk.common.utils;

import com.google.gson.Gson;

import java.util.Objects;

public class GsonBuilder {

    private static final com.google.gson.GsonBuilder INSTANCE = new com.google.gson.GsonBuilder();
    private static volatile Gson GSON_INSTANCE;

    static {
        INSTANCE.disableHtmlEscaping();
    }

    public static Gson create() {
        if (Objects.isNull(GSON_INSTANCE)) {
            synchronized (INSTANCE) {
                if (Objects.isNull(GSON_INSTANCE)) {
                    GSON_INSTANCE = INSTANCE.create();
                }
            }
        }
        return GSON_INSTANCE;
    }
}
