package com.dao;

import com.bean.User;

import java.util.List;

public interface UserDao {
    //public     boolean     saveUser(  User user);
    public     User     findUserByUseranmeAndPassword(User user);
    //public     User        findUserByUserName(String username);
    public User selectUser(String uid);
    public List<User> selectAllUser();
    public void insertUser(User user);
    public void deleteUser(String uid);

}
