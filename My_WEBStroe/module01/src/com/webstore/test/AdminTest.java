package com.webstore.test;

import com.webstore.bean.Admin;
import com.webstore.dao.AdminDao;
import org.junit.Test;

public class AdminTest {

    @Test
    public void test1(){
        Admin admin=new Admin("1","admin","123");
        System.out.println(AdminDao.saveAdmin(admin));
    }

    @Test
    public void test2(){
        System.out.println(AdminDao.findAllAdmin());
    }

    @Test
    public void test3(){
        //System.out.println(AdminDao.UpdateAdmin("1","admin","123"));
    }

    @Test
    public void test4(){
        System.out.println(AdminDao.findAdminByNameAndPassword("admin","123"));
    }
}
