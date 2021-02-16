package com.demo.config.imports.registar.config;

import com.demo.config.imports.registar.CarBeanDefinitionRegistar;
import com.demo.config.imports.registar.anno.EnableCar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CarBeanDefinitionRegistar.class)
@EnableCar
public class CarConfiguration {

}
