package com.demo.config.tk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 *  通用mybatis的配置
 */
@Configuration
public class TkMapperConfig {

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.demo.dao");
        Properties properties = new Properties();
        properties.put("mappers","tk.mybatis.mapper.common.Mapper");
        configurer.setProperties(properties);
        return configurer;
    }
}
