package com.livedrof.springCloud.eureka.consumer;

import com.livedrof.springCloud.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {
    @Autowired
    UserService userService;

    public void test() {
        this.userService.findUsers();
    }
}
