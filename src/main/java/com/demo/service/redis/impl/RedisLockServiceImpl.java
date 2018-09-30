package com.demo.service.redis.impl;

import com.demo.bean.redis.RedisLockBusBean;
import com.demo.bean.result.Result;
import com.demo.service.redis.RedisLockService;
import com.demo.util.resp.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisLockServiceImpl implements RedisLockService {

    private static final Logger logger = LogManager.getLogger(RedisLockServiceImpl.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result doLock(String key, String value, RedisLockBusBean bean) throws Exception {
        logger.info("try to lock key=" + key + ",value=" + value);
        stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        if (value.equals(currentValue)) {
            logger.info("successfully locked key=" + key + ",value=" + value);
            try {
                return bean.doInLock();
            } finally {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
                logger.info("released locked key=" + key + ",value=" + value);
            }
        } else {
            logger.info("failed to locked key=" + key + ",value=" + value + " due to crash");
            return bean.doInCrash(currentValue);
        }
    }

    @Override
    public Result doLockWait(String key, String value, long expirationTime, RedisLockBusBean bean) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();

        while (System.currentTimeMillis() - currentTimeMillis < expirationTime * 1000) {
            logger.info("try to lock key=" + key + ",value=" + value);
            stringRedisTemplate.opsForValue().setIfAbsent(key, value);
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (value.equals(currentValue)) {
                logger.info("successfully locked key=" + key + ",value=" + value);
                try {
                    return bean.doInLock();
                } finally {
                    stringRedisTemplate.opsForValue().getOperations().delete(key);
                    logger.info("released locked key=" + key + ",value=" + value);
                }
            }
        }
        return ResponseUtil.setBusErrorResponse("lock was taken up by other thread too long,so returned");
    }

}
