package homework03.com.cskaoyan.proxy;

import homework03.com.cskaoyan.bean.Account;

import java.sql.SQLException;

public interface AccountService {
    public void transfer(Account outAccount, Account inAccount, int money) throws SQLException;
}
