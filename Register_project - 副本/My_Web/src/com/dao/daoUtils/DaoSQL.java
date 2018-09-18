package com.dao.daoUtils;

import com.dao.UserDao;
import com.model.User;
import com.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DaoSQL{


    public boolean saveUser(User user) {
        boolean ret=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("insert into user values(null,?,?,?)", user.getUsername(), user.getPassword(), user.getAge());
            if (update==1){
                ret =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  ret;
    }


    public boolean findUserByUseranmeAndPassword(String username, String password) {
        Connection connection = DBCPUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        boolean flag=false;
        if(connection!=null){
            try {
                String sql="SELECT * FROM user WHERE username = ? AND password = ?";
                statement=connection.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(2,password);
                System.out.println(sql);
                resultSet=statement.executeQuery();
                while(resultSet.next())  //游标指向下一行;
                {
                    flag=true;
                    break;
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(flag+username+" "+password);
        return flag;
    }

    public static User findUserByUserName(String username) {
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
    public static void deleteUserByUserName(String username){
        if(username!=null) {
            QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
            try {
                queryRunner.update("delete from user where username = '" + username + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean deleteUserByUserId(int id){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            queryRunner.update("delete from user where uid = "+id);
            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
    public static List<User> findAllUser(){
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        List<User> query=null;
        try {
            query=queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return query;
    }

}
