package com.livedrof.springboot2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @RequestMapping("/future")
    public Object future() {
        System.out.println("async/create call,thread:" + Thread.currentThread().getName());
        Future future = this.asyncExceptionDemo.hardDemo("hello");
        try {
            System.out.println("future.get():" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        this.asyncExceptionDemo.inputDemo("hello async");
        return "asyc success";
    }


}
