package com.test;

import com.dao.daoUtils.DaoSQL;
import com.utils.DBCPUtils;
import org.junit.Test;

import java.sql.Connection;

public class Mytest {

    @Test
    public void mytest(){

        Connection connection=DBCPUtils.getConnection();

        System.out.println("conn  "+connection);

    }

    @Test
    public void test1(){
        DaoSQL.deleteUserByUserName("1111");
    }
}
