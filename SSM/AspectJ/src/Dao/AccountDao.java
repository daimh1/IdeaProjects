package Dao;


import bean.Account;

public interface AccountDao {
    public Account findAccountById(int id);
    public void update(Account account);
}
