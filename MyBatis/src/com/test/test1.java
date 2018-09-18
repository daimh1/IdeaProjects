package com.test;

import com.bean.User;
import com.dao.UserDao;
import com.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test1 {
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
    public void test1() throws IOException {

        //获取factory


        //
        SqlSession sqlSession=sqlSessionFactory.openSession();

        try {
            User user=sqlSession.selectOne("wangdao.selectUser",2);
            System.out.println("user:"+user);
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void test2(){
        SqlSession session=sqlSessionFactory.openSession();

        try {
            User user=new User(0,"aaa","123","wangdao@123.com");
            //session.insert("wangdao.insertUser",user);
            int insert = session.insert("wangdao.insertUser", user);

            System.out.println("insert="+insert);
        }finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void testQueryAll()  {


        //通过sqlSessionFactory获取sqlSession的实例，并通过该实例去执行sql语句
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<User> userlist = session.selectList("wangdao.selectAllUser");

            System.out.println("userlist="+userlist);

        } finally {
            session.close();
        }
    }

    @Test
    public void testUpdate(){

        //通过sqlSessionFactory获取sqlSession的实例，并通过该实例去执行sql语句
        SqlSession session = sqlSessionFactory.openSession();
        try {


            User user =new User();
            user.setId(2);
            user.setUsername("aaa");
            user.setPassword("aaa");
            user.setEmail("aaa@cskaoayn.com");
            int update = session.update("wangdao.updateUser", user);
            //bean中变量名大小写要和#{}内一致
            System.out.println("update="+update);

        } finally {
            session.commit();
            session.close();
        }
    }

    @Test
    public void test3(){
        //String resource="mybatis.xml";
        //InputStream inputStream=null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);

        User user=mapper.selectUser(2);
        System.out.println(user);
        //通过dao这个接口，让mybatis产生一个具体的实现类(动态代理)



    }
    @Test
    public void test4(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User user=mapper.findUserById(-1);
        System.out.println(user);
    }

    @Test
    public void test5(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> user=mapper.findUsersByMultiCondition(new User(2,"aaa",null,null));
        System.out.println(user);
    }
}
