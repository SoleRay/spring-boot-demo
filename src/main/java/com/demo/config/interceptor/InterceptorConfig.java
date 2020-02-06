package com.demo.config.interceptor;

import com.demo.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(new DemoInterceptor())
                .addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
