package com.myweb.service;

import com.myweb.bean.User;

public interface UserService {


   User login(String username, String password);

   boolean   register(User user);
}
