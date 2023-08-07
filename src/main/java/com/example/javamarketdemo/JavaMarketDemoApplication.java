package com.example.javamarketdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class JavaMarketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMarketDemoApplication.class, args);
    }


}
