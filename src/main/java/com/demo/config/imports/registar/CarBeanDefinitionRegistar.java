package com.demo.config.imports.registar;

import com.demo.config.imports.registar.anno.EnableCar;
import com.demo.config.imports.registar.bean.Car;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class CarBeanDefinitionRegistar implements ImportBeanDefinitionRegistrar {

    private static final String DEFAULT_CAR_ATTR_NAME = "name";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map<String, Object> enableCarAttributes = importingClassMetadata.getAnnotationAttributes(EnableCar.class.getName());
        if(enableCarAttributes!=null && !enableCarAttributes.isEmpty()){
            String beanName = ((String) enableCarAttributes.get(DEFAULT_CAR_ATTR_NAME));

            if(!registry.containsBeanDefinition(beanName)){
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setBeanClass(Car.class);
                registry.registerBeanDefinition(beanName,beanDefinition);
            }

        }
    }
}
