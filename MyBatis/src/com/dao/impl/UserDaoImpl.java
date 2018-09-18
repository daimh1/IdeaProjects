package com.dao.impl;

import com.bean.User;
import com.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    {

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

    @Override
    public User findUserById(String id) {
        User user=null;
        SqlSession session =null;
        try {

            session = sqlSessionFactory.openSession();
            user = session.selectOne("wangdao.selectUser", id);

            System.out.println("user="+user);

        } finally {
            session.close();
        }

        return  user;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public User selectUser(int id) {
        return null;
    }
}
