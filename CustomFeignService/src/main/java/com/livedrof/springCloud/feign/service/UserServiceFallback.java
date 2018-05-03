package com.livedrof.springCloud.feign.service;

import com.livedrof.springCloud.feign.dto.User;

import java.util.List;

//@Component
public class UserServiceFallback implements UserService{
    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
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
