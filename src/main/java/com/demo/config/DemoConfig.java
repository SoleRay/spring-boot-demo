package com.demo.config;

import com.demo.bean.common.base.PlainBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DemoConfig {

//    @Bean
    protected PlainBean plainBean(){
        return new PlainBean();
    }
}
