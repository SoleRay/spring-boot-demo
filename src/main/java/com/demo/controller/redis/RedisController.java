package com.demo.controller.redis;

import com.demo.bean.result.Result;
import com.demo.service.redis.RedissonService;
import com.demo.util.resp.ResponseUtil;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedissonService redissonService;

    @RequestMapping(value = "/redisson/test")
    public Result redissonTest() throws Exception {

        String value = UUID.randomUUID().toString();
        RLock lock = redissonService.getRLock(value);
        try {
            boolean bs = lock.tryLock(5, -1, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("进入业务代码: " + value);
                Thread.sleep(20000);
                log.info("hello: " + value);
            } else {
                Thread.sleep(300);
            }
        } catch (Exception e) {
            log.error("", e);
            lock.unlock();
            throw e;
        } finally {
            lock.unlock();
        }
        return ResponseUtil.setDefaultSuccessResponse();
    }
}
