package com.livedrof.springCloud.feign.consumer;

import com.livedrof.springCloud.feign.api.CustomUserServiceApi;
import com.livedrof.springCloud.feign.dto.User;
import com.livedrof.springCloud.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConsumer {
    @Autowired
    DiscoveryClient client;

    @Autowired
    private CustomUserServiceApi userService;

    public User getUserById(int userId) {
        return null;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("getUsers from " + UserConsumer.class);
        System.out.println(this.client.getServices());
        return this.userService.getUsers();
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
