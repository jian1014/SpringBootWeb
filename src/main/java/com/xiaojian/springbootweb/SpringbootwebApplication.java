package com.xiaojian.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.xiaojian")
public class SpringbootwebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootwebApplication.class, args);
    }
}
