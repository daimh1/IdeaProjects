package com.webstore.service;

import com.webstore.bean.Order;
import com.webstore.dao.OrderDao;
import com.webstore.dao.ProductDao;

import java.util.List;
import java.util.UUID;

public class OrderService {
    public boolean addOrder(Order obj){
        return OrderDao.saveOrder(obj);
    }

    public List<Order> orderList(){
        return OrderDao.findAllOrder();
    }

    public boolean modifyOrder(Order obj,String oid){
        boolean ret=false;
        if(OrderDao.UpdateOrder(oid,obj)){ret=true;}
        return ret;
    }

    public boolean deleteOrder(String oid){
        return OrderDao.deleteOrderById(oid);
    }

    public boolean addPnum(String pid,String num){
        return ProductDao.pluspnumByPid(num,pid);
    }

    public List<Order> userOrderList(String uid){
        return OrderDao.accountOrder(uid);
    }

    public Order findOrderByOid(String oid){
        return OrderDao.findOrderById(oid);
    }
}
