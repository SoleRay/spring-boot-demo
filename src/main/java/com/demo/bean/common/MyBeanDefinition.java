package com.demo.bean.common;

import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Constructor;

public class MyBeanDefinition extends RootBeanDefinition {

    public MyBeanDefinition(Class<?> beanClass) {
        super(beanClass);
    }

    public MyBeanDefinition(MyBeanDefinition original) {
        super(original);
    }


    @Override
    public Constructor<?>[] getPreferredConstructors() {
        Class<?> beanClass = getBeanClass();
        return beanClass.getDeclaredConstructors();
    }

    @Override
    public RootBeanDefinition cloneBeanDefinition() {
        return new MyBeanDefinition(this);
    }
}
