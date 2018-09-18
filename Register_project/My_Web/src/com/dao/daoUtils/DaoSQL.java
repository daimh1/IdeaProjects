package com.dao.daoUtils;

import com.bean.User;
import com.dao.UserDao;

import com.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DaoSQL{

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


    public boolean saveUser(User user) {
        boolean ret=false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);
        try {
            mapper.insertUser(user);

            ret =true;

        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
        return  ret;
    }


    public boolean findUserByUseranmeAndPassword(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);
        boolean flag=false;

        User user=new User();
        user.setUsername("1234");
        user.setPassword("123");
        User myuser=null;
        myuser=mapper.findUserByUseranmeAndPassword(user);
        if(myuser!=null){
            flag=true;
        }
        return flag;
    }

    public User findUserByUserName(String username) {
        User user=null;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());

        try {
            user = queryRunner.query("select * from user where username = ? ",
                    new Object[]{username}
                    , new BeanHandler<User>(User.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  user;
    }
    public void deleteUserByUserName(String username){
        if(username!=null) {
            QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
            try {
                queryRunner.update("delete from user where username = '" + username + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean deleteUserByUserId(String id){
        boolean flag=false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);
        try {
            mapper.deleteUser(id);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

        return flag;
    }
    public List<User> findAllUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper=sqlSession.getMapper(UserDao.class);
        List<User> query=null;

        query=mapper.selectAllUser();


        return query;
    }

}
