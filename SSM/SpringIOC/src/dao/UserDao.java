package dao;

import bean.User;

public interface UserDao {
    User findUserByUsernameAndPassword(String username,String password);
}
