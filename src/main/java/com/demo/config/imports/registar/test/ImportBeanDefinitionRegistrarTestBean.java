package com.demo.config.imports.registar.test;

import com.demo.test.AbstarctTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ImportBeanDefinitionRegistrarTestBean extends AbstarctTestBean {

    @Override
    protected void doAfterSingletonsInstantiated(ApplicationContext applicationContext) {
        System.out.println(applicationContext.getBean("car"));
    }
}
