package com.demo.config.imports.selector.test;

import com.demo.config.imports.selector.anno.EnableApple;
import com.demo.config.imports.selector.anno.EnableBox;
import com.demo.config.imports.selector.bean.Apple;
import com.demo.config.imports.selector.bean.Box;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@EnableApple
@EnableBox
@Component
public class SelectorTestBean implements ApplicationContextAware, SmartInitializingSingleton {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        if(applicationContext.containsBean("apple")){
            Apple apple = applicationContext.getBean("apple", Apple.class);
            System.out.println(apple);
        }
        if(applicationContext.containsBean("box")){
            Box box = applicationContext.getBean("box", Box.class);
            System.out.println(box);
        }

    }
}
