package com.demo.bean.common.annotation.construct;

import com.demo.bean.common.base.Apple;
import com.demo.bean.common.base.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AnnBeanConstruct {


    public AnnBeanConstruct() {
    }

    @Autowired(required = false)
    public AnnBeanConstruct(@Value(value = "8")int age,
                            @Value(value = "john") String name,
                            @Value(value = "1")int gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Autowired(required = false)
    public AnnBeanConstruct(@Value(value = "9")int age,
                            @Value(value = "simam") String name,
                            @Qualifier("apple") Fruit fruit) {
        this.age = age;
        this.name = name;
        this.fruit = fruit;
    }

    @Autowired(required = false)
    public AnnBeanConstruct(@Value(value = "10") Integer age,
                            @Value(value = "fuck") String name,
                            @Qualifier("greenApple") Apple apple) {
        this.age = age;
        this.name = name;
        this.fruit = apple;
    }

    //唯一构造器
//    @Autowired
    public AnnBeanConstruct(@Value(value = "212")int age,
                            @Value(value = "yian") String name,
                            @Value(value = "54sss") String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }


    private int age;

    private String name;

    private int gender;

    private String address;

    private Fruit fruit;

    @Override
    public String toString() {
        return "AnnBeanConstruct{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", fruit=" + fruit +
                '}';
    }
}
