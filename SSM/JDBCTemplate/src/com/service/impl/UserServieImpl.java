package com.service.impl;


import com.bean.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userserivce")
public class UserServieImpl implements UserService {


    @Autowired
    UserDao dao;

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(id);
    }

    @Override
    public boolean add(User user) {
        return dao.add(user);
    }

    @Override
    public boolean delete(String id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(String id, User user) {
        return dao.updateuser(id,user);
    }
}
