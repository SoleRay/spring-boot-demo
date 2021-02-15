package com.demo.config.imports.selector.anno;

import com.demo.config.imports.selector.AppleImportSelector;
import com.demo.config.imports.selector.enums.ConfigEnum;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AppleImportSelector.class)
public @interface EnableApple {

    ConfigEnum config() default ConfigEnum.APPLE;
}
