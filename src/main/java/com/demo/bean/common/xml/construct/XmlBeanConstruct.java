package com.demo.bean.common.xml.construct;

import com.demo.bean.common.base.Apple;
import com.demo.bean.common.base.Fruit;

public class XmlBeanConstruct {


    public XmlBeanConstruct(int age, String name, int gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public XmlBeanConstruct(int age, String name, Fruit fruit) {
        this.age = age;
        this.name = name;
        this.fruit = fruit;
    }

    public XmlBeanConstruct(Integer age, String name, Apple apple) {
        this.age = age;
        this.name = name;
        this.fruit = apple;
    }

    private int age;

    private String name;

    private int gender;

    private String address;

    private Fruit fruit;
}
