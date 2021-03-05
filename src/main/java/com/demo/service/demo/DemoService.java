package com.demo.service.demo;

import com.demo.entity.demo.Demo;
import com.demo.service.base.BaseService;

import java.util.List;

public interface DemoService extends BaseService<Demo> {


    void batchInsertDemos(List<Demo> demoList);
}
