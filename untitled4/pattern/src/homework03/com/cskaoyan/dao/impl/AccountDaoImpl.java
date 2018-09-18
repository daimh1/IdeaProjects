package homework03.com.cskaoyan.dao.impl;

import homework03.com.cskaoyan.bean.Account;
import homework03.com.cskaoyan.dao.AccountDao;
import homework03.com.cskaoyan.utils.DBUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class AccountDaoImpl implements AccountDao {


    @Override
    public boolean transferMoney(String from, String to, String money) {

        Connection connection =null;
        PreparedStatement preparedStatement =null;

        boolean flag=false;
        Savepoint savepoint_transfer_Ok =null;
        try {

            connection= DBUtils.getConnection();

            //在这里声明，开启事物 (表明后续的对数据库的操作属于同一个事物)
            connection.setAutoCommit(false); //start transaction


            //从from的账号减money
            String sql_sub="update account set money= money- ? where id = ?";
            preparedStatement = connection.prepareStatement(sql_sub);
            preparedStatement.setInt(1,Integer.parseInt(money));
            preparedStatement.setInt(2,Integer.parseInt(from));
            int ret1 = preparedStatement.executeUpdate();
            System.out.println("ret1="+ret1);


            //int i=1/0;

            //从to的账户增加money
            String sql_add="update account set money= money+ ? where id = ?";
            preparedStatement= connection.prepareStatement(sql_add);
            preparedStatement.setInt(1,Integer.parseInt(money));
            preparedStatement.setInt(2,Integer.parseInt(to));
            int ret2 = preparedStatement.executeUpdate();
            System.out.println("ret1="+ret2);

            //转账的主业务完成之后，在此设置一个回滚点
            savepoint_transfer_Ok = connection.setSavepoint();


            int[] arr={1,2,3};
            System.out.println("aaa"+arr[4]);


            //从to的账户增加money
            String sql_gift="update account set money= money+ ? where id = ?";
            preparedStatement= connection.prepareStatement(sql_gift);
            preparedStatement.setInt(1,1);//额外奖励一块
            preparedStatement.setInt(2,Integer.parseInt(from));
            int ret3 = preparedStatement.executeUpdate();
            System.out.println("ret3="+ret3);



            //当逻辑上，组成该事物的所有的sql语句都执行完毕之后，提交事务。 让这一组操作都生效
            connection.commit();  //commit



            flag=true;
        }catch (ArithmeticException e){

            e.printStackTrace();

            //当发生异常的时候，就回滚
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (IndexOutOfBoundsException e){

            //这个时候
            if (connection!=null&&savepoint_transfer_Ok!=null){
                try {
                    connection.rollback(savepoint_transfer_Ok);  //
                    //回滚到某些回滚点，这些回滚点之前数据库的写操作，如需要生效，则必须手动提交。
                    connection.commit();


                    flag=true;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        }

        catch (Exception e){
            e.printStackTrace();

            //当发生异常的时候，就回滚
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            DBUtils.realse(null,preparedStatement,connection);
        }


        return  flag;
    }

    @Override
    public int updateAccount(Account account) throws SQLException {
        return 0;
    }

    @Override
    public Account getAccountInfo(String id) throws SQLException {
        return null;
    }


}
