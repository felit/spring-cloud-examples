package com.livedrof.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncExceptionDemo asyncExceptionDemo;

    @RequestMapping("/create")
    public Object hello() {
        System.out.println("async/create call,thread:" + Thread.currentThread().getName());
        this.asyncExceptionDemo.simple();
//        this.asyncExceptionDemo.inputDemo("hello async");
        return "asyc success";
    }

}
