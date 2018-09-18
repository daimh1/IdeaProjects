package com.webstore.dao;

import com.webstore.bean.ShoppingCart;
import com.webstore.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ShoppingCartDao {

    public static boolean addShoppingCart(ShoppingCart shoppingCart){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());

        try {
            int update = queryRunner.update("insert into shoppingcart values(?,?,?,?)", shoppingCart.getId(),shoppingCart.getUid(),shoppingCart.getPid(),shoppingCart.getPnum());
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

    public static boolean removeShoppingCart(String id){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from shoppingcart where id=?", id);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean deleteAllShoppingCart(){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from shoppingcart where 1=1");
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static List<ShoppingCart> shoppingCartListByUser(String uid){
        List<ShoppingCart> query=null;
        QueryRunner queryRunner=new QueryRunner(DBCPUtils.getDataSource());

        try {
            query=queryRunner.query("select * from shoppingcart where uid=?",uid,new BeanListHandler<ShoppingCart>(ShoppingCart.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static ShoppingCart shoppingCartByUidAndPid(String uid,String  pid){
        ShoppingCart query=null;
        QueryRunner queryRunner=new QueryRunner(DBCPUtils.getDataSource());

        try {
            query=queryRunner.query("select * from shoppingcart where uid="+uid+" and pid=?",pid,new BeanHandler<ShoppingCart>(ShoppingCart.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static boolean addnum(String num,String id){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());

        try {
            int update = queryRunner.update("update shoppingcart set pnum=pnum+? where id=?",num, id);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

}

