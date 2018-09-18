package com.myweb.dao;

import com.myweb.bean.User;

import java.util.HashMap;

public interface UserDao {


    User findUserByUserNameAndPassword(HashMap map);

    int insertUser(User user);


}
