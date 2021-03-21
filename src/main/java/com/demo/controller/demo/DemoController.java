package com.demo.controller.demo;

import com.demo.anno.ResponseResult;
import com.demo.entity.demo.Demo;
import com.demo.service.demo.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@ResponseResult
@RequestMapping("/demo")
public class DemoController {

    private AtomicInteger count = new AtomicInteger(1);

    @Autowired
    private DemoService demoService;

    @PostMapping(value="/selectDemo")
    public Demo selectDemo(Integer id){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        log.info("count {}",count.getAndIncrement());
//        if(log.isDebugEnabled()){
//            log.debug("select demo start....");
//        }
//        Demo demo = demoService.selectByPrimaryKey(id);
        Demo demo = new Demo();
        return demo;
    }

    @GetMapping(value="/reset")
    public void reset(){
        count.setRelease(1);
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
