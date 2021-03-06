package com.zoeyun.swift.sdk.common.redis.lock;


import com.github.jedis.lock.JedisLock;
import com.zoeyun.swift.sdk.common.exception.SdkRuntimeException;
import lombok.NonNull;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.Pool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现简单的jedis分布锁
 */
public class JedisDistributedLock implements Lock {

    private final Pool<Jedis> jedisPool;
    private final JedisLock lock;

    public JedisDistributedLock(Pool<Jedis> jedisPool, String key) {
        this.jedisPool = jedisPool;
        this.lock = new JedisLock(key);
    }

    @Override
    public void lock() {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!lock.acquire(jedis)) {
                throw new SdkRuntimeException("acquire timeouted");
            }
        } catch (InterruptedException e) {
            throw new SdkRuntimeException("lock failed", e);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!lock.acquire(jedis)) {
                throw new SdkRuntimeException("acquire timeouted");
            }
        }
    }

    @Override
    public boolean tryLock() {
        try (Jedis jedis = jedisPool.getResource()) {
            return lock.acquire(jedis);
        } catch (InterruptedException e) {
            throw new SdkRuntimeException("lock failed", e);
        }
    }

    @Override
    public boolean tryLock(long l, @NonNull TimeUnit timeUnit) throws InterruptedException {
        try (Jedis jedis = jedisPool.getResource()) {
            return lock.acquire(jedis);
        }
    }

    @Override
    public void unlock() {
        try (Jedis jedis = jedisPool.getResource()) {
            lock.release(jedis);
        }
    }

    @NonNull
    @Override
    public Condition newCondition() {
        throw new SdkRuntimeException("unsupported method");
    }
}
