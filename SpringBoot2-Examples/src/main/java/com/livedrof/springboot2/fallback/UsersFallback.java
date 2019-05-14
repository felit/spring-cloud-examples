package com.livedrof.springboot2.fallback;

import com.livedrof.springboot2.feign.UserFeignClient;
import com.livedrof.springboot2.feign.vo.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UsersFallback implements UserFeignClient {
    @Override
    public List<User> brandList() {
        return Collections.emptyList();
    }
}
