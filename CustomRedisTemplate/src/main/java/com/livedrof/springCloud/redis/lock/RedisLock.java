package com.livedrof.springCloud.redis.lock;
/**
 * Redis的分布式锁对象
 */
public interface RedisLock extends AutoCloseable {

    /**
     * 释放分布式锁
     */
    void unlock();
}