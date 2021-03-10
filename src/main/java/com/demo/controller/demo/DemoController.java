package com.demo.controller.demo;

import com.demo.anno.ResponseResult;
import com.demo.bean.result.Result;
import com.demo.bean.result.ResultCode;
import com.demo.entity.demo.Demo;
import com.demo.exception.BusinessException;
import com.demo.service.demo.DemoService;
import com.demo.util.mock.MockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RestController
@ResponseResult
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping(value="/selectDemo")
    public Demo selectDemo(Integer id){
        log.info("select demo start....");
//        if(log.isDebugEnabled()){
//            log.debug("select demo start....");
//        }
        Demo demo = demoService.selectByPrimaryKey(id);
        return demo;
    }

    @PostMapping(value="/insertDemo")
    public void insertDemo(Demo demo){
        demoService.insert(demo);
    }

    @PostMapping(value="/updateDemo")
    public void updateDemo(Demo demo){
        demoService.updateByPrimaryKey(demo);
    }

    @PostMapping(value="/batchInsert")
    public void batchInsert(){
        List<Demo> demoList = MockUtil.createList(10, (i) -> {
            Demo demo = new Demo();
            demo.setId(i);
            demo.setDemoName("demoName:" + i);
            demo.setDemoKey("demoKey:" + i);
            demo.setCreateDate(LocalDateTime.now());
            return demo;
        });

        demoService.batchInsertDemos(demoList);
    }

}
