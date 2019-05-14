package com.livedrof.springboot2.service.impl;

import com.livedrof.springboot2.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void ss() {
        log.info(Thread.currentThread().getName());
    }
}
