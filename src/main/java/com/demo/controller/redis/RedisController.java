package com.demo.controller.redis;

import com.demo.anno.ResponseResult;
import com.demo.bean.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/set")
    public void set(String key,String value) throws Exception {
        redisTemplate.opsForValue().set(key,value);
    }

    @RequestMapping(value = "/get")
    public Object get(String key) throws Exception {
        Object value = redisTemplate.opsForValue().get(key);
        return value;
    }

    @RequestMapping(value = "/batchSet")
    public void batchSet(int loop) throws Exception {
        for(int i=0;i<loop;i++){
            redisTemplate.opsForValue().set(i+"",i+"");
        }
    }

    @RequestMapping(value = "/batchHSet")
    public void batchHSet(int loop) throws Exception {
        for(int i=0;i<loop;i++){
            redisTemplate.opsForHash().putIfAbsent("box","sub-"+i,i+"");
        }
    }

}
