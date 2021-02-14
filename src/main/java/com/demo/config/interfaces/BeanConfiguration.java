package com.demo.config.interfaces;

import com.entity.Box;
import org.springframework.context.annotation.Bean;

/**
 * see {@link org.springframework.context.annotation.ConfigurationClassPostProcessor}#
 * doProcessConfigurationClass() => processInterfaces()
 * processInterfaces处理配置类所实现的接口中的父类
 */
public interface BeanConfiguration {

    @Bean("box")
    default Box getBox(){
        return new Box();
    }
}
