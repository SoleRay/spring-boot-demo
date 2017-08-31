package com.demo.config.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * Created by Arthur on 2017/1/4 0004.
 */
@Configuration
public class MybatisConfig {

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("biz.ohome.dao");
        Properties properties = new Properties();
        properties.put("mappers","tk.mybatis.mapper.common.Mapper");
        configurer.setProperties(properties);
        return configurer;
    }
}
