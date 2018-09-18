package com.dao;

import com.model.User;

public interface UserDao {
    public     boolean     saveUser(  User user);
    public     boolean     findUserByUseranmeAndPassword(String username, String password);
    public     User        findUserByUserName(String username);
}
