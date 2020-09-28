package com.demo.controller.demo;

import com.demo.anno.ResponseResult;
import com.demo.bean.result.Result;
import com.demo.bean.result.ResultCode;
import com.demo.entity.demo.Demo;
import com.demo.exception.BusinessException;
import com.demo.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping(value="/selectDemo")
    public Demo selectDemo(Integer id){
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

}
