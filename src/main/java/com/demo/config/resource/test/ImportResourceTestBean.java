package com.demo.config.resource.test;

import com.demo.test.AbstarctTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ImportResourceTestBean extends AbstarctTestBean {

    @Override
    protected void doAfterSingletonsInstantiated(ApplicationContext applicationContext) {
        System.out.println(applicationContext.getBean("plane"));
    }
}
