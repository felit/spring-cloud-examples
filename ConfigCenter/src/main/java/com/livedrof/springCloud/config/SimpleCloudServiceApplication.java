package com.livedrof.springCloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleCloudServiceApplication {

    public static void main(String[] args) {
//        args = new String[1];
//        args[0] = "--spring.profiles.active=simple2";
//        SpringApplication.run(SimpleCloudServiceApplication.class, args);
        SpringApplication.run(SimpleCloudServiceApplication.class);
    }
}