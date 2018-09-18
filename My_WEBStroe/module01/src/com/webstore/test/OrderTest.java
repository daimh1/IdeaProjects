package com.webstore.test;

import com.webstore.bean.Order;
import com.webstore.dao.OrderDao;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class OrderTest {

    @Test
    public void test1(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        Order order=new Order(uuid,"10","zhangsan","10086","深圳","1",timeStamp.toString(),"1");
        System.out.println(OrderDao.saveOrder(order));
    }

    @Test
    public void test2(){
        System.out.println(OrderDao.findAllOrder());
    }

    @Test
    public void test3(){
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        System.out.println(OrderDao.UpdateOrder("1f2d15e8ab3d427381d4ae0280c6d516","10","zhangsan","10086","深圳","1",timeStamp.toString(),"1"));
    }

    @Test
    public void test4(){
        System.out.println(OrderDao.findOrderById("1f2d15e8ab3d427381d4ae0280c6d516"));
    }

    public void test5(){

    }
}
