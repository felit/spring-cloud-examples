package com.livedrof.springboot2.controller;

import com.livedrof.springboot2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private IUserService userService;

    @Autowired
    private AsyncExceptionDemo asyncExceptionDemo;

    @RequestMapping("/create")
    public Object hello() {
        System.out.println("async/create call,thread:" + Thread.currentThread().getName());
        this.asyncExceptionDemo.simple();
//        this.asyncExceptionDemo.inputDemo("hello async");
        return "asyc success";
    }

    @RequestMapping("/future")
    public Object future() {
        System.out.println("async/create call,thread:" + Thread.currentThread().getName());
        Future future = this.asyncExceptionDemo.hardDemo("hello");
        this.userService.ss();
        return "asyc success";
    }


}
