package Dao;


import bean.Account;

import java.sql.Connection;

public interface AccountDao {
    public Account findAccountById(int id);
    public void update(Account account);
}
