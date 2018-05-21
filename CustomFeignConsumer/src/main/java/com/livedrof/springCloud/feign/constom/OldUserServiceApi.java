package com.livedrof.springCloud.feign.constom;

import com.livedrof.springCloud.feign.constom.config.JsonIgnorePropertiesFeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "custom-feign-service", configuration = JsonIgnorePropertiesFeignConfig.class)
public interface OldUserServiceApi {
    @RequestMapping(value = "/getUserById")
    User getUserById(int userId);

    @RequestMapping(value = "/getUsers")
    List<User> getUsers();

    @RequestMapping(value = "/createUser")
    User createUser(User user);

    @RequestMapping(value = "/deleteUser")
    boolean deleteUser(int userId);

    @RequestMapping(value = "/updateUser")
    User updateUser(User user);
}
