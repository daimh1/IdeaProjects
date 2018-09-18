package Dao;

import Utils.JDBCUtils;
import Utils.TransactionManager;
import bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao{
    public Account findAccountById(int id){
        String sql = "select * from account where id = ?";
        Object[] params = {id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            return queryRunner.query(TransactionManager.getConnection(),sql, new BeanHandler<Account>(Account.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 更新账户: 接受传递的连接
    public void update(Account account){
        String sql = "update account set name = ?, money = ? where id = ?";
        Object[] params = {account.getName(), account.getMoney(), account.getId()};
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(TransactionManager.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
