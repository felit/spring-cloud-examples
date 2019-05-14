package com.livedrof.springboot2.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
//@Async("orderExecutor")
/**
 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'orderExecutor' available: No matching Executor bean found for qualifier 'orderExecutor' - neither qualifier match nor bean name match!
 */
public class OrderController {
    @RequestMapping("/create")
    public Object hello() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        return "world";
    }
}
