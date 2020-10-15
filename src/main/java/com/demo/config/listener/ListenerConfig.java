package com.demo.config.listener;

import com.demo.listener.DemoListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.HttpSessionEventPublisher;

//@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean registerDemoListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new DemoListener());
        return servletListenerRegistrationBean;
    }

//    @Bean
//    public ServletListenerRegistrationBean registerHttpSessionEventPublisher(){
//        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
//        servletListenerRegistrationBean.setListener(new HttpSessionEventPublisher());
//        return servletListenerRegistrationBean;
//    }
}
