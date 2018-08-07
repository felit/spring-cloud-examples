package com.livedrof.springCloud.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCommands;

/**
 * https://www.cnblogs.com/linjiqin/p/8003838.html Redis分布式锁的正确实现方式
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/users/lock", method = RequestMethod.GET)
    public String getUsers() {
        this.logger.info("用户信息加锁 user: {} value:{} ", "users", "value1");
        Object result = this.redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            JedisCommands conn = (JedisCommands) redisConnection.getNativeConnection();
            String lockResult = conn.set("users", "locked", "nx", "px", 8000l);
            System.out.println(lockResult);
            return "OK".equals(lockResult);
        });
        this.logger.info("用户信息加锁 user: {} value:{},加锁完成:{} ", "users", "value1", result);

        return result.toString();
    }

    @RequestMapping(value = "/users/unlock", method = RequestMethod.GET)
    public String unlockUsers() {
        /**
         *
         */
        Object result = this.redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            System.out.println(redisConnection.getNativeConnection().getClass());
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Long result1 = redisConnection.eval(script.getBytes(), ReturnType.INTEGER, 1, "users".getBytes(), "locked".getBytes());
            return result1.equals(1l);
        });
        return result.toString();
    }
}
