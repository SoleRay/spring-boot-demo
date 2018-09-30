package com.demo.service.redis;


import com.demo.bean.redis.RedisLockBusBean;
import com.demo.bean.result.Result;

public interface RedisLockService {
    Result doLock(String key, String value, RedisLockBusBean bean) throws Exception;

    Object doLockWait(String key, String value, long expirationTime, RedisLockBusBean bean) throws Exception;
}
