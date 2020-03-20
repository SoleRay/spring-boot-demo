package com.demo.controller.cache;

import com.demo.bean.result.Result;
import com.demo.entity.demo.Demo;
import com.demo.service.cache.CacheService;
import com.demo.util.resp.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping(value="/findNameById")
    public Result findNameById(Long id){
        String name = cacheService.findNameById(id);
        return ResponseUtil.setSuccessDataResponse(name);
    }
}
