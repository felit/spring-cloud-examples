package com.livedrof.springCloud.feign.service.impl;

import com.livedrof.springCloud.feign.dto.User;
import com.livedrof.springCloud.feign.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@RestController
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        System.out.println("getUsers");
        return Collections.singletonList(new User());
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
