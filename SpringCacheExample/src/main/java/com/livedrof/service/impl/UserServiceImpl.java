package com.livedrof.service.impl;

import com.livedrof.service.UserService;
import com.livedrof.service.vo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {


    @Caching(cacheable={
//            @Cacheable(cacheNames = "users", key = "#userId"),
            @Cacheable(cacheNames = "users", key = "#userId")
    })
    public User getUserById(Long userId) {
        System.out.println("user:" + 900);
        return new User(200L);
    }
}
