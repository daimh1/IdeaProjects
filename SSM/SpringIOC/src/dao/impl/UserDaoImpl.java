package dao.impl;

import bean.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        if("wangdao".equals(username)&&"123".equals(password)){
            return new User();
        }
        return null;
    }
}
