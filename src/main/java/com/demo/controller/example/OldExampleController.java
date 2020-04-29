package com.demo.controller.example;

import com.demo.bean.result.Result;
import com.demo.entity.demo.Demo;
import com.demo.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/old")
public class OldExampleController {

    @Autowired
    private DemoService demoService;

    @PostMapping(value="/selectDemo")
    public Result selectDemo(Integer id, @RequestParam String str){
        Demo demo = demoService.selectByPrimaryKey(id);
        return Result.success(demo);
    }

    @PostMapping(value="/updateDemo")
    public Result updateDemo(Demo demo){
        demoService.updateByPrimaryKeySelective(demo);
        return Result.success();
    }
}
