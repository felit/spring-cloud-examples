package com.livedrof.springCloud.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("hello-service")
public interface UserService {
    @RequestMapping("/findUsers")
    public List<String> findUsers();

    @RequestMapping("/hello")
    public String getUserName(int userId);
}
