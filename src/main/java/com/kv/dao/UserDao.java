package com.kv.dao;

import java.util.List;

import com.kv.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    int insert(User user);

    List<User> selectUsers();

    void insertMybatisBatch(List<User> userDomains);
}