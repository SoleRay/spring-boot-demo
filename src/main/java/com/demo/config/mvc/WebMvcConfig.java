package com.demo.config.mvc;

import com.demo.interceptor.DemoInterceptor;
import com.demo.interceptor.ResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加拦截器
        registry.addInterceptor(new DemoInterceptor())
                .addPathPatterns("/**");

        registry.addInterceptor(new ResultInterceptor())
                .addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("GET","POST","PUT","DELETE");
    }
}
