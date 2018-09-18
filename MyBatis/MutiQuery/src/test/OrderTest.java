package test;


import bean.Order;
import bean.OrderItem;
import bean.Student;
import dao2.OrderDao;
import dao2.OrderItemDao;
import homework03.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class OrderTest {

    private SqlSessionFactory sqlSessionFactory;


    //daoimpl 我们没有实现
    //希望由Mybatis来实现
    @Before
    public void init(){
        //通过sqlSessionFactory获取sqlSession的实例，并通过该实例去执行sql语句
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test1(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
        Order orderByOid = mapper.findOrderByOid(1);

        System.out.println("orderByoid="+orderByOid);
    }


    @Test
    public void test2(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderItemDao mapper = sqlSession.getMapper(OrderItemDao.class);
        OrderItem orderItemByid = mapper.findOrderItemById(1);

        System.out.println("orderItemByid="+orderItemByid);
    }

    @Test
    public void test3(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student studentBySid = mapper.findStudentBySid("1");


        System.out.println("studentBySid="+studentBySid);
    }
}
