package com.demo.config.aop.advisor;


import com.demo.config.aop.demo.DemoBeforeAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;

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
