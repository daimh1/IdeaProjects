package service.impl;

import bean.User;
import dao.impl.UserDaoImpl;
import service.UserService;
import dao.UserDao;

public class UserServiceImpl implements UserService {

    UserDao dao;

    public void setDao(UserDao dao){
        this.dao=dao;
    }

    @Override
    public boolean login(String username, String password) {
        User user=dao.findUserByUsernameAndPassword(username,password);
        return user==null?false:true;
    }
}
