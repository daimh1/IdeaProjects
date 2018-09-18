package com.myweb.test;

import com.myweb.dao.EmployeeDao;
import com.myweb.dao.UserDao;
import com.myweb.domain.Dept;
import com.myweb.domain.Employee;
import com.myweb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
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
    public void test1(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);

        User user=mapper.selectById(1);

    }
    @Test
    public void test2(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);

        //User user=mapper.count();

    }

    @Test
    public void test3(){
        Map<String,User> map=new HashMap<>();
        User user=new User();
        user.setId(1);
        user.setUsername("超级");
        user.setLoginname("bbb");
        user.setStatus(2);
        map.put("user",user);

        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);

        List<User> myuser=mapper.selectByPage(map);
        System.out.println(myuser);
    }

    @Test
    public void test4(){
        Map<String,Employee> map=new HashMap<>();
        Employee user=new Employee();
        user.setId(1);
        user.setName("alice");
        Dept dept=new Dept();
        dept.setId(1);
        dept.setName("财务部");
        user.setDept(dept);
        map.put("employee",user);

        SqlSession sqlSession=sqlSessionFactory.openSession();
        EmployeeDao mapper=sqlSession.getMapper(EmployeeDao.class);

        List<Employee> myuser=mapper.selectByPage(map);
        System.out.println(myuser);
    }
}
