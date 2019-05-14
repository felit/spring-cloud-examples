package com.livedrof.springboot2.controller;

import com.livedrof.springboot2.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Async("taskExecutor")
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/create")
    public Object hello() {
        long start = System.currentTimeMillis();
        System.out.println(this.userFeignClient.brandList());
        long end = System.currentTimeMillis();
        System.out.println("result(ms):" + (end - start));
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "world";
    }
}
