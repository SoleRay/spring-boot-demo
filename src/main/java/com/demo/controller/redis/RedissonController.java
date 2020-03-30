package com.demo.controller.redis;

import com.demo.bean.result.Result;
import com.demo.service.redis.RedissonService;
import com.demo.util.resp.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisson")
public class RedissonController {

    private static final Logger log = LoggerFactory.getLogger(RedissonController.class);

    @Autowired
    private RedissonService redissonService;

    @RequestMapping(value = "/test")
    public Result test() throws Exception {

//        String value = UUID.randomUUID().toString();
//        RLock lock = redissonService.getRLock(value);
//        try {
//            boolean bs = lock.tryLock(5, -1, TimeUnit.SECONDS);
//            if (bs) {
//                // 业务代码
//                log.info("进入业务代码: " + value);
//                Thread.sleep(20000);
//                log.info("hello: " + value);
//            } else {
//                Thread.sleep(300);
//            }
//        } catch (Exception e) {
//            log.error("", e);
//            lock.unlock();
//            throw e;
//        } finally {
//            lock.unlock();
//        }
        return ResponseUtil.setDefaultSuccessResponse();
    }
}
