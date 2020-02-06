package com.demo.config.listener;

import com.demo.listener.DemoListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean registerDemoListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new DemoListener());
        return servletListenerRegistrationBean;
    }
}
