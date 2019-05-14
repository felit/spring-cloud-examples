package com.livedrof.springboot2.feign;

import com.livedrof.springboot2.fallback.UsersFallback;
import com.livedrof.springboot2.feign.vo.User;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@EnableHystrix
@FeignClient(name = "erp", url = "${erp.host}", fallback = UsersFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "brand/list.do", method = RequestMethod.GET)
    List<User> brandList();
}
