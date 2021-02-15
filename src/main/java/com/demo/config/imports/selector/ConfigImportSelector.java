package com.demo.config.imports.selector;

import com.demo.config.imports.selector.candidates.AppleConfiguration;
import com.demo.config.imports.selector.candidates.BoxConfiguration;
import com.demo.config.imports.selector.enums.ConfigEnum;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.function.Predicate;

public abstract class ConfigImportSelector<A extends Annotation> implements ImportSelector {

    public static final String DEFAULT_CONFIG_ATTRIBUTE_NAME = "config";

    protected String getConfigName() {
        return DEFAULT_CONFIG_ATTRIBUTE_NAME;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //这个annType就是ConfigImportSelector<A> 中这个泛型A的类型，通常这个A就是Enable注解的类型
        Class<?> annType = GenericTypeResolver.resolveTypeArgument(getClass(), ConfigImportSelector.class);

        //获取Enable注解类的属性，它的属性其实就是方法
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(annType.getName(), false);

        if(annotationAttributes==null || annotationAttributes.isEmpty()){
            return new String[0];
        }

        try{
            //获取Enable注解类属性中的config属性，其实就是调用他的config()方法
            ConfigEnum configEnum = (ConfigEnum) annotationAttributes.get(getConfigName());
            switch (configEnum) {
                case APPLE:
                    return new String[] {AppleConfiguration.class.getName()};
                case BOX:
                    return new String[] {BoxConfiguration.class.getName()};
                default:
                    return null;
            }
        }catch (ClassCastException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
