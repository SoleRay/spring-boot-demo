package com.demo.bean.common.base;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Apple implements Fruit {

    private String color;

    private String shape;

    public Apple() {
    }

    public Apple(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    public void describe(){
        System.out.println("it's a kind of fruit");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
