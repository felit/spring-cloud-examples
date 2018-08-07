package com.livedrof.springCloud.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.DefaultPropertySourceFactory;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        DefaultPropertySourceFactory factory;
        SpringApplication.run(Application.class, args);
    }
}
