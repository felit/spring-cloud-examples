package com.livedrof.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HelloApplication {
    public static void main(String args[]) {
        SpringApplication.run(HelloApplication.class, args);
    }
}