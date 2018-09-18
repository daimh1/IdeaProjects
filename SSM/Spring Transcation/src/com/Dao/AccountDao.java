package com.Dao;


import com.bean.Account;

public interface AccountDao {
    public Account findAccountById(int id);
    public void update(Account account);
}
