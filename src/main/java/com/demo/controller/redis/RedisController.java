package com.demo.controller.redis;

import com.demo.bean.result.Result;
import com.demo.util.resp.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/set")
    public Result set(String key,String value) throws Exception {
        redisTemplate.opsForValue().set(key,value);
        return ResponseUtil.setDefaultSuccessResponse();
    }

    @RequestMapping(value = "/get")
    public Result get(String key) throws Exception {
        Object value = redisTemplate.opsForValue().get(key);
        return ResponseUtil.setSuccessDataResponse(value);
    }

    @RequestMapping(value = "/batchSet")
    public Result batchSet(int loop) throws Exception {
        for(int i=0;i<loop;i++){
            redisTemplate.opsForValue().set(i+"",i+"");
        }

        return ResponseUtil.setDefaultSuccessResponse();
    }

    @RequestMapping(value = "/batchHSet")
    public Result batchHSet(int loop) throws Exception {
        for(int i=0;i<loop;i++){
            redisTemplate.opsForHash().putIfAbsent("box","sub-"+i,i+"");
        }
        return ResponseUtil.setDefaultSuccessResponse();
    }
}
