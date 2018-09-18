package dao.impl;

import bean.User;
import dao.UserDao;

public class UserDaoImpl2 implements UserDao {
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        if("wangdao".equals(username)&&"1234".equals(password)){
            return new User();
        }
        return null;
    }

    public void initxxx(){
        System.out.println("this is an init method");
    }

    public void destory(){
        System.out.println("destory method");
    }
}
