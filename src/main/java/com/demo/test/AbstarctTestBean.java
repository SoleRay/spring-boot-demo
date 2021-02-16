package com.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class AbstarctTestBean implements ApplicationContextAware, SmartInitializingSingleton {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        doAfterSingletonsInstantiated(applicationContext);
    }

    protected abstract void doAfterSingletonsInstantiated(ApplicationContext applicationContext);
}
