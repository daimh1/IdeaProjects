package com.service;


import com.bean.User;

public interface UserService {

  User findUserById(String id);

  boolean add(User user);

  boolean delete(String id);

  boolean update(String id,User user);
}
