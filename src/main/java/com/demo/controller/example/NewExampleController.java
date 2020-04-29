package com.demo.controller.example;

import com.demo.anno.ResponseResult;
import com.demo.bean.result.Result;
import com.demo.bean.result.ResultCode;
import com.demo.entity.demo.Demo;
import com.demo.exception.BusinessException;
import com.demo.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
@RequestMapping("/example/new")
public class NewExampleController {

    @Autowired
    private DemoService demoService;

    @PostMapping(value="/selectDemo")
    public Demo selectDemo(){
        Demo demo = new Demo();
        demo.setId(1L);
        return demo;
    }

    @PostMapping(value="/updateDemo")
    public void updateDemo(){
        System.out.println("updated...");
    }

    @PostMapping(value="/insertDemo")
    public void insertDemo(){
        throw new BusinessException(ResultCode.PASSWORD_ERROR);
    }

    @PostMapping(value="/listDemos")
    public void listDemos(){
        int x = 1/0;
    }
}
