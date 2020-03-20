package com.demo.service.cache.impl;

import com.demo.dao.demo.DemoDao;
import com.demo.entity.demo.Demo;
import com.demo.service.cache.CacheService;
import com.demo.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private DemoService demoService;

    @Cacheable(cacheManager = "cacheManager", value = "demo-1", key = "#id")
    @Override
    public String findNameById(Long id) {
        Demo demo = demoService.selectByPrimaryKey(id);
        return demo.getDemoName();
    }
}
