package com.demo.bean.common.annotation.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnBeanInitAutowire implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean {

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private String beanName;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AnnBean InitializingBean...afterPropertiesSet");
    }

    public void initMethod(){
        System.out.println("AnnBean initMethod..");
    }

    public void destroyMethod(){
        System.out.println("AnnBean destroyMethod..");
    }


    @PostConstruct
    public void lifecycleInit(){
        System.out.println("AnnBean lifecycleInit..");
    }

    @PreDestroy
    public void lifecycleDestroy(){
        System.out.println("AnnBean lifecycleDestroy..");
    }


    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }
}
