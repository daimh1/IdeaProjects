package dao;

import bean.User;

public interface UserDao {

  User findUserById(int id);

}
