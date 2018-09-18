package homework03.com.cskaoyan.proxy;

import homework03.com.cskaoyan.bean.Account;
import homework03.com.cskaoyan.dao.impl.AccountDaoImpl;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer(Account outAccount, Account inAccount, int money) throws SQLException {
        AccountDaoImpl accountDAO = new AccountDaoImpl();
        outAccount = accountDAO.getAccountInfo(outAccount.getId());
        inAccount = accountDAO.getAccountInfo(inAccount.getId());

        // 转账 - 修改原账户金额
        outAccount.setMoney(outAccount.getMoney() - money);
        inAccount.setMoney(inAccount.getMoney() + money);

        // 更新账户金额
        accountDAO.updateAccount(outAccount);
        accountDAO.updateAccount(inAccount);

    }
}
