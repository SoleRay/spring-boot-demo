package com.demo.config.inner;

import com.demo.bean.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * see {@link org.springframework.context.annotation.ConfigurationClassPostProcessor}
 * doProcessConfigurationClass() => 处理@Component及其衍生注解 => processMemberClasses()
 *
 * 进一步查看内部有没有存在配置类。此时内部类即使没有@Configuration也可以，只要满足一下条件
 * 1.类上标记了@Component及其衍生注解
 * 2.类上标记了@ComponentScan
 * 3.类上标记了@Import
 * 4.类上标记了@ImportResource
 * 5.方法上标记了@Bean
 */
@Configuration
public class InnerClassConfiguration {


    class InnerBeanConfiguration{

        @Bean("box")
        public Apple getApple(){
            return new Apple();
        }
    }
}
