package com.demo.bean.common.annotation.depsOn;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@DependsOn("annBeanToDep")
@Lazy
public class AnnBeanDepOn {
}
