package com.livedrof.springcloud.hystrix.basic;

import org.junit.Test;

/**
 *failures, latency, timeouts and duplicate calls
 */
public class TestHelloWorldHystrixCommand {
    @Test
    public void test() throws InterruptedException {
        HelloWorldHystrixCommand<String> command = new HelloWorldHystrixCommand<String>("HLX");
        String result = command.execute();
        System.out.println(result);  // 打印出Hello HLX
        System.out.println("实现结果如下：" + result);
//        Thread.sleep(100000);
    }
}
