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
//, fallback = UserServiceFallback.class
@FeignClient(name = "CUSTOM-FEIGN-SERVICE")
public interface UserService {
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    List<User> getUsers();

}
