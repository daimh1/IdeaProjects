package com.dao;

import com.bean.User;

import java.util.List;

public interface UserMapper {

    User findUserById(int id);

    List<User> findUsersByMultiCondition(User user);
}
