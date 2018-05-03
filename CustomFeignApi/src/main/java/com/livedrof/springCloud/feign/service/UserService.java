package com.livedrof.springCloud.feign.service;

import com.livedrof.springCloud.feign.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 协议的定义与设计,
 * 类型:
 * boolean
 * Integer
 * Double
 * Float
 * Long
 * java.util.Date
 * List
 * Set
 * Map<>
 * Object
 * 泛型
 */
@FeignClient(name = "custom-feign-api", fallback = UserServiceFallback.class)
//@RequestMapping("/custom-feign-api/")
public interface UserService {
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    User getUserById(int userId);

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    List<User> getUsers();

    @RequestMapping(value = "/createUser")
    User createUser(User user);

    @RequestMapping(value = "/deleteUser")
    boolean deleteUser(int userId);

    @RequestMapping(value = "/updateUser")
    User updateUser(User user);
}
