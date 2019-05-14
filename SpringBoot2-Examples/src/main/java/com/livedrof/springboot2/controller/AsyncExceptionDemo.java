package com.livedrof.springboot2.controller;

import com.livedrof.springboot2.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncExceptionDemo {
    @Autowired
    private IUserService userService;
    @Async("asyncExecutor")
    public void simple() {
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("this is a void method,thread:" + Thread.currentThread().getName());
    }

    @Async("asyncExecutor")
    public void inputDemo(String s) {
        System.out.println("async/create: thread:" + Thread.currentThread().getName());
        log.info("this is a input method,{}", s);
        throw new IllegalArgumentException("inputError");
    }

    @Async
    public Future hardDemo(String s) {
        log.info("this is a hard method,{}", s);
        Future future;
        try {
            Thread.sleep(300);
            userService.ss();

            throw new IllegalArgumentException();

        } catch (InterruptedException e) {
            future = new AsyncResult("InterruptedException error");
        } catch (IllegalArgumentException e) {
            future = new AsyncResult("i am throw IllegalArgumentException error");
        }
        return future;
    }
}
