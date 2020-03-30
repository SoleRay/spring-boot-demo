package com.demo.controller.cache;

import com.demo.bean.result.Result;
import com.demo.entity.demo.Demo;
import com.demo.service.cache.CacheService;
import com.demo.util.resp.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping(value="/findNameById")
    public Result findNameById(Long id){
        Demo demo = cacheService.findNameById(id);
        return ResponseUtil.setSuccessDataResponse(demo);
    }

    @PostMapping(value="/deleteDemoById")
    public Result deleteDemoById(Long id){
        cacheService.deleteDemoById(id);
        return ResponseUtil.setDefaultSuccessResponse();
    }

    @PostMapping(value="/updateDemo")
    public Result updateDemo(Demo demo){
        Demo result = cacheService.updateDemo(demo);
        return ResponseUtil.setSuccessDataResponse(result);
    }
}
