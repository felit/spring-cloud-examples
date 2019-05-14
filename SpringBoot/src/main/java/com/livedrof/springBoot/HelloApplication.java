package com.livedrof.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * https://blog.csdn.net/king_is_everyone/article/details/53257815
 * https://blog.csdn.net/u013059432/article/details/72898138
 * https://blog.csdn.net/tiger0709/article/details/73526666
 * Application实例级别的参数
 * Initializers
 * Listeners
 * ResourceLoader
 * AdditionalProfiles
 * ApplicationContextClass
 * Banner
 * BeanNameGenerator
 * DefaultProperties
 * Environment
 * Headless
 * RegisterShutdownHook
 * Sources: 什么概念，可以多个应用?
 * WebEnvironment
 * LogStartupInfo
 *
 * 应用事件: Spring框架的事件，SpringApplication另加入的事件
 * 应用事件与监听器顺序及层次
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class HelloApplication {
    public static void main(String args[]) {
        SpringApplication application = new SpringApplication(HelloApplication.class, args);
        application.addListeners();
//        application.setApplicationContextClass();
//        SpringApplication.run(HelloApplication.class, args);
    }
}