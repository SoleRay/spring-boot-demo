package com.demo.bean.common.annotation.property.lookup;

import com.demo.bean.common.base.PlainBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AnnBeanLookup {

    @Lookup
    public PlainBean getBeanPlainBean(){
        return null;
    };
}
