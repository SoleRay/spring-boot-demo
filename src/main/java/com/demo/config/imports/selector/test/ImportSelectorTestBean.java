package com.demo.config.imports.selector.test;

import com.demo.config.imports.selector.anno.EnableApple;
import com.demo.config.imports.selector.anno.EnableBox;
import com.demo.config.imports.selector.bean.Apple;
import com.demo.config.imports.selector.bean.Box;
import com.demo.test.AbstarctTestBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@EnableApple
@EnableBox
@Component
public class ImportSelectorTestBean extends AbstarctTestBean {

    @Override
    protected void doAfterSingletonsInstantiated(ApplicationContext applicationContext) {
        if(applicationContext.containsBean("apple")){
            System.out.println(applicationContext.getBean("apple", Apple.class));
        }
        if(applicationContext.containsBean("box")){
            System.out.println(applicationContext.getBean("box", Box.class));
        }
    }
}
