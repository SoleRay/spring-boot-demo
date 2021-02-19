package com.demo.config.conditional.config;

import com.demo.config.conditional.bean.Cat;
import com.demo.config.conditional.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    @ConditionalOnBean(Cat.class)
    public Cat cat(){
        return new Cat();
    }

    @Bean
    @ConditionalOnMissingBean
    public Dog dog(){
        return new Dog();
    }
}
