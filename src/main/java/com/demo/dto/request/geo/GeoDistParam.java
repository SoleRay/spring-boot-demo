package com.demo.dto.request.geo;

import com.demo.dto.base.redis.RedisKeyParam;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GeoDistParam extends RedisKeyParam {

    private String member1;

    private String member2;
}
