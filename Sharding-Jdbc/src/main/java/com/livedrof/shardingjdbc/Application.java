package com.livedrof.shardingjdbc;

import com.google.common.collect.Lists;
import com.livedrof.shardingjdbc.dao.IUserDao;
import com.livedrof.shardingjdbc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String args[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IUserDao userDao = ac.getBean(IUserDao.class);
//        for (int i = 10000; i < 10000000; i++) {
//            userDao.insertUser(new User((long) i, "hello"));
//        }
        List<User> users = userDao.getUsers(Lists.newArrayList(21L, 22L, 23L, 24L));
        List<User> us = new ArrayList<User>();
        us.add(new User(100000L, "2000"));
        us.add(new User(100001L, "10000990"));
        userDao.batchInsertUsers(us);
        System.out.println(users);
        System.out.println("-------");

    }
}