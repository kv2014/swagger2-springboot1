package com.kv.service.user;

import com.kv.result.DataResult;
import com.kv.model.User;


public interface UserService {

    int addUser(User user);

    DataResult<User> findAllUser(int pageNum, int pageSize);

    void insertMybatisBatch();
}
