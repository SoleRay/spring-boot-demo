package com.demo.bean.common.annotation.circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AnnX {

    @Autowired
    private AnnY annY;

    public AnnX() {
        System.out.println("AnnX is created...");
    }
}
