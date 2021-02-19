package com.demo.config.conditional.test;

import com.demo.test.AbstarctTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class ConditionalTestBean extends AbstarctTestBean {

    @Override
    protected void doAfterSingletonsInstantiated(ApplicationContext applicationContext) {

        Consumer<Object> c = System.out::println;

        Function<String,Object> f = t -> applicationContext.containsBean(t);
        c.accept(f.apply("cat"));
        c.accept(f.apply("dog"));
    }
}
