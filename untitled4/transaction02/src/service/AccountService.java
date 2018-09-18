package service;

import Dao.AccountDao;
import Utils.JDBCUtils;
import bean.Account;

import java.sql.SQLException;
import java.sql.Connection;

public class AccountService {

    public void transfer(Account outAccount,Account inAccount,int money) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        conn.setAutoCommit(false);

        // 查询两个账户
        AccountDao accountDAO = new AccountDao();
        outAccount = accountDAO.findAccountById(outAccount.getId());
        inAccount = accountDAO.findAccountById(inAccount.getId());

        // 转账 - 修改原账户金额
        outAccount.setMoney(outAccount.getMoney() - money);
        inAccount.setMoney(inAccount.getMoney() + money);

        try {
            // 更新账户金额, 注意: 这里往Dao层传递连接
            accountDAO.update(outAccount, conn);
            // int x = 1 / 0;
            accountDAO.update(inAccount, conn);

            // 转账成功, 提交事务
            conn.commit();
        } catch (Exception e) {
            // 转账失败, 回滚事务
            conn.rollback();
            e.printStackTrace();
        }

    }
}
