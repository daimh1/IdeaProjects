package service;

import Dao.AccountDao;
import Dao.AccountDaoImpl;
import bean.Account;
import factory.ServiceFactory;

public class AccountServiceImpl implements AccountService {

    AccountDao dao=new AccountDaoImpl();

    /*public void transfer(int outid,int inid,int money){
        Connection conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);

        // 查询两个账户
        AccountDao accountDAO = new AccountDaoImpl();
        Account outAccount = accountDAO.findAccountById(outid);
        Account inAccount = accountDAO.findAccountById(inid);

        // 转账 - 修改原账户金额
        outAccount.setMoney(outAccount.getMoney() - money);
        inAccount.setMoney(inAccount.getMoney() + money);


            // 更新账户金额, 注意: 这里往Dao层传递连接
            accountDAO.update(outAccount, conn);
            // int x = 1 / 0;
            accountDAO.update(inAccount, conn);

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

    }*/
    public boolean transfer(int outid, int inid, int money) {
        boolean flag = false;
        Account accountInfo_from = dao.findAccountById(outid);
        Account accountInfo_to = dao.findAccountById(inid);

        accountInfo_from.setMoney(accountInfo_from.getMoney() - money);
        dao.update(accountInfo_from);


        //int i = 1 / 0;

        accountInfo_to.setMoney(accountInfo_to.getMoney() + money);
        dao.update(accountInfo_to);

        flag = true;


        return flag;

    }

    @Override
    public void setDao(AccountDao dao) {
        this.dao=dao;
    }
}