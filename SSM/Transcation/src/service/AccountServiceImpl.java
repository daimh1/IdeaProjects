package service;

import Dao.AccountDao;
import Utils.JDBCUtils;
import bean.Account;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{
    public void transfer(Account out, Account in, int money){
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);

        // 查询两个账户
        AccountDao accountDAO = new AccountDao();
        Account outAccount = accountDAO.findAccountById(out.getId());
        Account inAccount = accountDAO.findAccountById(in.getId());

        // 转账 - 修改原账户金额
        outAccount.setMoney(outAccount.getMoney() - money);
        inAccount.setMoney(inAccount.getMoney() + money);


            // 更新账户金额, 注意: 这里往Dao层传递连接
            accountDAO.update(outAccount,conn);
            // int x = 1 / 0;
            accountDAO.update(inAccount,conn);

            // 转账成功, 提交事务
            conn.commit();
        } catch (Exception e) {
            // 转账失败, 回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
