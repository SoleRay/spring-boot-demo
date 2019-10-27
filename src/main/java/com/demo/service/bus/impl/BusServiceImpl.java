package com.demo.service.bus.impl;

import com.demo.entity.demo.Demo;
import com.demo.service.bus.BusService;
import com.demo.service.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private DemoService demoService;

    @Transactional
    public void doBusinsess(){
        Demo d = new Demo();
        d.setDemoKey("color");
        d.setDemoName("blue");
        demoService.add(d);

        d.setId(2L);
        d.setDemoName("purple");
        demoService.change(d);

        int x = 1/0;
    }


    @Transactional
    public void doBusinsess2(){
        Demo d = new Demo();
        d.setDemoKey("color");
        d.setDemoName("blue");
        demoService.addWithNewTrans(d);

        d.setId(2L);
        d.setDemoName("purple");
        demoService.change(d);

        int x = 1/0;
    }

    @Transactional
    public void doBusinsess3(){
        Demo d = new Demo();
        d.setDemoKey("color");
        d.setDemoName("blue");
        demoService.addWithNESTED(d);

        d.setId(2L);
        d.setDemoName("purple");
        demoService.change(d);

        int x = 1/0;
    }
}
