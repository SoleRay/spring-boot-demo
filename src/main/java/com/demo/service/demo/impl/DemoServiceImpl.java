package com.demo.service.demo.impl;

import com.demo.bean.page.Pageable;
import com.demo.dao.demo.DemoDao;
import com.demo.dto.request.demo.DemoListReqDTO;
import com.demo.dto.response.demo.DemoListRespDTO;
import com.demo.dto.response.page.PageInfoRespDTO;
import com.demo.dto.response.page.PageListRespDTO;
import com.demo.entity.demo.Demo;
import com.demo.service.base.impl.BaseServiceImpl;
import com.demo.service.demo.DemoService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements DemoService{

    @Autowired
    private DemoDao demoDao;

    /**
     * mybatis 适用于单表和一对一多表关联查询，不适合一对多
     */
    @Override
    public PageListRespDTO getAllDemos(long userId,int pageNum, int pageSize){
        Page<Demo> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                demoDao.selectAll();
            }
        });
        return new PageListRespDTO(page.getResult(),new PageInfoRespDTO(page.getPageNum(),page.getPageSize(),page.getTotal(),page.getPages()));

    }

    /**
     * mybatis 一对多手动分页，手动写分页sql
     */
    @Override
    public PageListRespDTO getDemoList(long userId, int pageNum, int pageSize) {
        Pageable pageable = new Pageable(pageNum,pageSize);
        List<DemoListRespDTO> demoList =  demoDao.getDemoList(userId,pageable.getStart(),pageable.getPageSize());

        long count = demoDao.countDemoList(userId);
        PageInfoRespDTO pageInfo = pageable.genPageInfo(count);
        PageListRespDTO pageList= new PageListRespDTO();

        pageList.setContent(demoList);
        pageList.setPageInfo(pageInfo);
        return pageList;
    }
}
