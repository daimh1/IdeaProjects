package com.test;

import com.bean.User;
import com.dao.UserDao;
import com.dao.daoUtils.DaoSQL;
import com.utils.DBCPUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class Mytest {
    String resource="mybatis.xml";
    InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

    @Test
    public void mytest(){

        Connection connection=DBCPUtils.getConnection();

        System.out.println("conn  "+connection);

    }

    @Test
    public void test1(){
        //DaoSQL.deleteUserByUserName("1111");
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);

        User user=new User();
        user.setUsername("1234");
        user.setPassword("123");
        User myuser=mapper.findUserByUseranmeAndPassword(user);
        System.out.println(myuser);
    }
}
