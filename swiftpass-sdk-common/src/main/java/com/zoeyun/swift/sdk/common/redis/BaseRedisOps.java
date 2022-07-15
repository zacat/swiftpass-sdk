package com.zoeyun.swift.sdk.common.redis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class BaseRedisOps implements RedisOps {

    @Override
    public String getValue(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValue(String key, String value, int expire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long getExpire(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void expire(String key, int expire, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Lock getLock(String key) {
        throw new UnsupportedOperationException();
    }

}

