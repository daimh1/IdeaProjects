package com.webstore.dao;

import com.webstore.bean.Order;
import com.webstore.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    public static boolean saveOrder(Order order) {
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("insert into orderlist values(?,?,?,?,?,?,?,?)", order.getOid(),order.getMoney(),order.getRecipients(),order.getTel(),order.getAddress(),order.getState(),order.getOrdertime(),order.getUid());
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

    public static List<Order> findAllOrder(){
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        List<Order> query=null;
        try {
            query=queryRunner.query("select * from orderlist", new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static boolean UpdateOrder(String oid, String money, String recipients, String tel, String address, String state, String ordertime, String uid){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("update orderlist set money=?,recipients=?,tel=?,address=?,state=?,ordertime=?,uid=? where oid=?",oid,money,recipients,tel,address,state,ordertime,uid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteOrderById(String oid){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from orderlist where oid=?", oid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Order findOrderById(String oid){
        Order order=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            order= queryRunner.query("select * from orderlist where oid=?",oid,new BeanHandler<Order>(Order.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }




}
