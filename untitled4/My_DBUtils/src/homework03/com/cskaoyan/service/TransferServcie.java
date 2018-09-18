package homework03.com.cskaoyan.service;

import homework03.com.cskaoyan.bean.Account;
import homework03.com.cskaoyan.dao.AccountDao;
import homework03.com.cskaoyan.dao.impl.AccountDaoImpl;
import homework03.com.cskaoyan.utils.TransactionUtils;

import java.sql.SQLException;

public class TransferServcie {


    AccountDao dao = new AccountDaoImpl();

    //具体转账操作：

   /* public boolean transfer(String from, String to, String money)   {

        return  dao.transferMoney(from,to,money);


    }*/

   //要在service增加事物变得很困难
    public boolean transfer(String from, String to, String money) throws Exception {


        boolean flag=false;
        //dao说我只负责增删改查 具体操作
        //在此通过连接池获取一个connection，然后传给两个或者多个dao的操作，
        //开启事务
        try{

             //开启事物
            TransactionUtils.beganTransaction();


            //自己来具体操作
            int money_int = Integer.parseInt(money);
            Account accountInfo_from = dao.getAccountInfo(from);
            Account accountInfo_to= dao.getAccountInfo(to);

            accountInfo_from.setMoney(accountInfo_from.getMoney()-money_int);
            dao.updateAccount(accountInfo_from);

            int i=1/0;

            accountInfo_to.setMoney(accountInfo_to.getMoney()+money_int);
            dao.updateAccount(accountInfo_to);

            TransactionUtils.commit();
            flag=true;
        }  catch (Exception e) {
               e.printStackTrace();


                try {
                    TransactionUtils.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                throw  new Exception("sql eror!");
        }


        return  flag;


    }
}
