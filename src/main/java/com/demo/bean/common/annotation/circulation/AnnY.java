package com.demo.bean.common.annotation.circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AnnY {

    @Autowired
    private AnnX annX;

    public AnnY() {
        System.out.println("AnnY is created...");
    }
}
