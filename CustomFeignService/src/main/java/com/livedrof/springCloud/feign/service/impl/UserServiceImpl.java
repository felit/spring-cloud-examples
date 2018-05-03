package com.livedrof.springCloud.feign.service.impl;

import com.livedrof.springCloud.feign.dto.User;
import com.livedrof.springCloud.feign.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@RestController
public class UserServiceImpl implements UserService {
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        System.out.println("getUsers");
        return Collections.singletonList(new User());
    }

    public User createUser(User user) {
        return null;
    }

    public boolean deleteUser(int userId) {
        return false;
    }

    public User updateUser(User user) {
        return null;
    }
}
