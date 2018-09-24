package com.livedrof.shardingjdbc;

import com.livedrof.shardingjdbc.dao.IUserDao;
import com.livedrof.shardingjdbc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String args[]) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IUserDao userDao = ac.getBean(IUserDao.class);
        for (int i = 17; i < 1000; i++) {
            userDao.insertUser(new User((long) i, "hello"));
        }
//        userDao.insertUser(new User(16L, "hello"));
        System.out.println("-------");
    }
}