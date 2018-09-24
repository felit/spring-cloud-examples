package com.livedrof.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * https://blog.csdn.net/king_is_everyone/article/details/53257815
 * https://blog.csdn.net/u013059432/article/details/72898138
 * https://blog.csdn.net/tiger0709/article/details/73526666
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class HelloApplication {
    public static void main(String args[]) {
        SpringApplication.run(HelloApplication.class, args);
    }
}