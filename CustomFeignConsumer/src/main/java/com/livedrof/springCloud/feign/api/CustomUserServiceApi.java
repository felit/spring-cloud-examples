package com.livedrof.springCloud.feign.api;

import com.livedrof.springCloud.feign.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "custom-feign-service",url = "http://localhost:1113")
public interface CustomUserServiceApi extends UserService {
}
