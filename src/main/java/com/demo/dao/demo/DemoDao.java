package com.demo.dao.demo;

import com.demo.dao.base.BaseDao;
import com.demo.entity.demo.Demo;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface DemoDao extends BaseDao<Demo> {

    void batchInsertDemos(List<Demo> demoList);
}