package com.demo.dto.request.geo;

import com.demo.dto.base.redis.RedisKeyParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GeoRadiusByMemberParam extends RedisKeyParam {

    private String member;

    private double radius;


}
