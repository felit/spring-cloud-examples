package com.livedrof.springCloud.feign.api;

import com.livedrof.springCloud.feign.dto.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsumerFallback implements CustomUserServiceApi {
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
