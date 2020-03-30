package com.demo.controller.geo;

import com.demo.bean.result.Result;
import com.demo.dto.request.geo.*;
import com.demo.util.resp.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/geo")
public class GeoController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/add")
    public Result add(@RequestBody GeoAddParam param) throws Exception {

        Point point = new Point(param.getLng(),param.getLat());
        redisTemplate.opsForGeo().add(param.getKey(), new RedisGeoCommands.GeoLocation(param.getMember(),point));
        return ResponseUtil.setDefaultSuccessResponse();
    }

    @RequestMapping(value = "/dist")
    public Result dist(@RequestBody GeoDistParam param) throws Exception {
        Distance distance = redisTemplate.opsForGeo().distance(param.getKey(), param.getMember1(), param.getMember2());
        return ResponseUtil.setSuccessDataResponse(distance);
    }

    @RequestMapping(value = "/pos")
    public Result pos(@RequestBody GeoPosParam param) throws Exception {
        List<String> position = redisTemplate.opsForGeo().position(param.getKey(),param.getMembers().toArray());
        return ResponseUtil.setSuccessDataResponse(position);
    }

    @RequestMapping(value = "/radius")
    public Result radius(@RequestBody GeoRadiusParam param) throws Exception {
        Circle circle = new Circle(param.getLng(),param.getLat(),param.getRadius());
        GeoResults results = redisTemplate.opsForGeo().radius(param.getKey(), circle);
        return ResponseUtil.setSuccessDataResponse(results);
    }

    @RequestMapping(value = "/radiusbymember")
    public Result radiusbymember(@RequestBody GeoRadiusByMemberParam param) throws Exception {
        GeoResults results = redisTemplate.opsForGeo().radius(param.getKey(), param.getMember(),param.getRadius());
        return ResponseUtil.setSuccessDataResponse(results);
    }
}
