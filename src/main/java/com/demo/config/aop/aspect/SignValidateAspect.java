package com.demo.config.aop.aspect;

import com.demo.exception.SignException;
import com.demo.util.sign.SignUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//@Aspect
//@Configuration
@Order(0)
public class SignValidateAspect {

    @Pointcut(value = "execution(public * com.demo.controller..*(..)) && @annotation(com.demo.anno.ValidateSign)")
    public void checkSign(){};
    
    @Before("checkSign()")
    public void before(JoinPoint jp) {

        //从http request中获取参数
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        Map<String, String[]> paramMap = request.getParameterMap();

        //校验参数
        if(!SignUtil.checkSign(paramMap)){
            throw new SignException("签名错误！");
        }
    }
}
