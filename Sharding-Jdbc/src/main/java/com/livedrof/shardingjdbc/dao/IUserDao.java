package com.livedrof.shardingjdbc.dao;

import com.livedrof.shardingjdbc.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {
    void insertUser(User user);

    List<User> getUsers(List<Long> ids);

    void batchInsertUsers(List<User> users);
}
