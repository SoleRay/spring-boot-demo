package com.demo.service.demo;

import com.demo.dto.response.page.PageListRespDTO;
import com.demo.entity.demo.Demo;
import com.demo.service.base.BaseService;

public interface DemoService extends BaseService<Demo> {
    PageListRespDTO getAllDemos(long userId,int pageNum, int pageSize);

    PageListRespDTO getDemoList(long userId,int pageNum, int pageSize);
}
