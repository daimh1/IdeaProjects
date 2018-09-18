package com.dao;

import com.bean.User;

public interface UserDao {

    User findUserById(String id);

    boolean add(User user);

    boolean delete(String id);

    boolean updateuser(String id,User user);

}
