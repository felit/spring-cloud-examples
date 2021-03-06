package com.livedrof.springCloud.eureka.controller;

import com.livedrof.springCloud.eureka.consumer.UserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
    UserConsumer userConsumer;

    /**
     * com.netflix.client.ClientException: Load balancer does not have available server for client: hello-service
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        this.userConsumer.test();
        return "hello";
    }
}
