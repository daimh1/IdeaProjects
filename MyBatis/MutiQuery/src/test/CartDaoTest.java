package test;

import bean.Cart;
import bean.CartExt;
import dao.CartDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CartDaoTest {


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

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CartDao mapper = sqlSession.getMapper(CartDao.class);

        Cart cartById = mapper.findCartById(1);

        System.out.println("cart"+cartById);


    }

    @Test
    public void test2(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        CartDao mapper = sqlSession.getMapper(CartDao.class);

        CartExt cartById = mapper.findCartById2(1);

        System.out.println("CartExt"+cartById);

    }
}
