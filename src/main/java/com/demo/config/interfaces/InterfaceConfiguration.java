package com.demo.config.interfaces;

import com.demo.config.imports.selector.bean.Box;
import com.demo.config.interfaces.bean.InterfaceBean;
import org.springframework.context.annotation.Bean;



/**
 * see {@link org.springframework.context.annotation.ConfigurationClassPostProcessor}#
 * doProcessConfigurationClass() => processInterfaces()
 * processInterfaces处理配置类所实现的接口中的父类
 */
public interface InterfaceConfiguration {

    @Bean
    default InterfaceBean interfaceBean(){
        return new InterfaceBean();
    }
}
