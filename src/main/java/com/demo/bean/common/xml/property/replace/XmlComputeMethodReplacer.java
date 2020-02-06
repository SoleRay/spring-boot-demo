package com.demo.bean.common.xml.property.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class XmlComputeMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        int value = (int) args[0];
        int count = (int) args[1];
        int result = value * count;
        return result;
    }
}
