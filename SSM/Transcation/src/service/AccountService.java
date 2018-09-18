package service;

import bean.Account;

public interface AccountService {

    public void transfer(Account outAccount, Account inAccount, int money);

}
