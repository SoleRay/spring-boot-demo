package com.demo.config.aop.advisor;


import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DemoAdvisor {

//    @Autowired
    private DemoBeforeAdvice advice;

//    @Bean
    public Advisor getAdvisor(){
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setAdvice(advice);
        advisor.setExpression("execution(public * com.demo.controller..*(..)) && @annotation(com.demo.anno.ValidateSign)");
        return advisor;
    }
}
