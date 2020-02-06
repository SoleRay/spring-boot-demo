package com.demo.bean.common.xml.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class XmlBeanInitAutowire implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean {

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
        System.out.println("XmlBean InitializingBean...afterPropertiesSet");
    }

    public void initMethod(){
        System.out.println("XmlBean initMethod..");
    }

    public void destroyMethod(){
        System.out.println("XmlBean destroyMethod..");
    }

    public void lifecycleInit(){
        System.out.println("XmlBean lifecycleInit..");
    }

    public void lifecycleDestroy(){
        System.out.println("XmlBean lifecycleDestroy..");
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
