package com.demo.dao.demo;

import com.demo.dto.response.demo.DemoListRespDTO;
import com.demo.entity.demo.Demo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DemoDao extends Mapper<Demo> {

    List<DemoListRespDTO> getDemoList(@Param("userId") long userId,
                                      @Param("start") long start,
                                      @Param("pageSize") int pageSize);

    long countDemoList(long userId);
}
