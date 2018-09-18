package com.homework04.service;

import com.homework04.Dao.AccountDao;

public interface AccountService {

    public boolean transfer(int outid, int inid, int money);
    public  void setDao(AccountDao dao);

}
