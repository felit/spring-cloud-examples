package com.livedrof.shardingjdbc.dao;

import com.livedrof.shardingjdbc.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {
    void insertUser(User user);
}
