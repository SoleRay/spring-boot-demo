package com.config.interfaces;

import com.entity.Box;
import org.springframework.context.annotation.Bean;

public interface BeanConfiguration {

    @Bean("box")
    default Box getBox(){
        return new Box();
    }
}
