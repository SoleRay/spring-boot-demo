package com.demo.config.aop.demo;


import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoAdvisor {

    @Bean
    public Advisor getAdvisor(DemoBeforeAdvice advice){
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setAdvice(advice);
        advisor.setExpression("execution(public * com.demo.controller..*(..)) && @annotation(com.demo.anno.SignCheck)");
        return advisor;
    }
}
