package com.service;

import com.Dao.AccountDao;

public interface AccountService {

    public boolean transfer(int outid, int inid, int money);
    public  void setDao(AccountDao dao);

}
