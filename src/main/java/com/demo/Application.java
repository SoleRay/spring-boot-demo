package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * 请格外注意此类所处的目录位置，这是spring boot官方推荐的位置
 * 在这个位置，你可以使用@SpringBootApplication
 * 或者你使用 @ComponentScan注解而不需要指定basePackage
 * 所以这里的@ComponentScan已经注释掉了
 *
 */


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}