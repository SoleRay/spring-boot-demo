package com.demo.config.imports.selector.candidates;

import com.demo.config.imports.selector.bean.Box;
import org.springframework.context.annotation.Bean;

//@Configuration
public class BoxConfiguration {

    @Bean
    public Box box(){
        return new Box();
    }
}
