package com.infogalaxy.springdemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoAppApplication.class, args);
    }

}
