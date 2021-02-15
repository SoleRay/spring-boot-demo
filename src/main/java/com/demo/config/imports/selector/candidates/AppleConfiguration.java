package com.demo.config.imports.selector.candidates;

import com.demo.config.imports.selector.bean.Apple;
import org.springframework.context.annotation.Bean;

//@Configuration
public class AppleConfiguration {

    @Bean
    public Apple apple(){
        return new Apple();
    }
}
