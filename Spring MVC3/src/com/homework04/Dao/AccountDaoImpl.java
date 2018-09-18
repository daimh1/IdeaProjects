package com.homework04.Dao;

import com.bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{


    @Autowired
    public AccountDaoImpl(DataSource dataSource){
        setDataSource(dataSource);
    }


    public Account findAccountById(int id){
        String sql = "select * from account where id = ?";
        /*Object[] params = {id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            return queryRunner.query(TransactionManager.getConnection(),sql, new BeanHandler<Account>(Account.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        Account account=getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Account>(Account.class),id).get(0);
        return account;
    }

    // 更新账户: 接受传递的连接
    public void update(Account account){
        String sql = "update account set name = ?, money = ? where id = ?";
        /*Object[] params = {account.getName(), account.getMoney(), account.getId()};
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(TransactionManager.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        int update = getJdbcTemplate().update(
                sql,
                account.getName(),
                account.getMoney(),
                account.getId());
    }
}
