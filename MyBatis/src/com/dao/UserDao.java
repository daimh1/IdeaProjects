package com.dao;

import com.bean.User;

import java.util.List;

public interface UserDao {
    User findUserById(String id);

    List<User> selectAllUser();

    User selectUser(int id);
}
