package com.livedrof.springcloud.hystrix.basic;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldHystrixCommand<T> extends HystrixCommand<T> {
    private String name;

    protected HelloWorldHystrixCommand(String group) {
        super(HystrixCommandGroupKey.Factory.asKey(group));
        this.name = group;
    }

    @Override
    protected T run() throws Exception {
        Thread.sleep(20000);
        //TODO 是怎么取消的？
        System.out.println("run执行");
        Thread.dumpStack();
        return (T) ("Hello" + this.name);
    }

    @Override
    protected T getFallback() {
        Thread.dumpStack();
        return (T) ("fallback: " + name);
    }
}
