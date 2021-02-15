package com.demo.config.imports.selector.anno;

import com.demo.config.imports.selector.BoxImportSelector;
import com.demo.config.imports.selector.ConfigImportSelector;
import com.demo.config.imports.selector.enums.ConfigEnum;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BoxImportSelector.class)
public @interface EnableBox {

    ConfigEnum config() default ConfigEnum.BOX;
}
