package com.livedrof.springCloud.eureka.service.impl;

import com.livedrof.springCloud.eureka.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserServiceImpl implements UserService {
    @Override
    public List<String> findUsers() {
        return Collections.emptyList();
    }

    @Override
    public String getUserName(int userId) {
        return "hello world";
    }

}
