package com.webstore.dao;

import com.webstore.bean.User;
import com.webstore.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public static boolean saveUser(User user) {
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("insert into user values(?,?,?,?,?,?,?)", user.getUid(),user.getUsername(),user.getNickname(),user.getPassword(),user.getEmail(),user.getBirthday(),user.getRegisterdate());
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
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


    public static boolean UpdateUser(String uid, User user){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("update user set username=?,nickname=?,password=?,email=?,birthday=? where uid=?",user.getUsername(),user.getNickname(),user.getPassword(),user.getEmail(),user.getBirthday(),uid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteUserById(String uid){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from user where uid=?", uid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static User findUserByNameAndPassword(String username,String password){
        User user=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            user= queryRunner.query("select * from user where username='"+username+"' and password='"+password+"'",new BeanHandler<User>(User.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User findUserByName(String username){
        User user=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            user= queryRunner.query("select * from user where username=?",username,new BeanHandler<User>(User.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static User findUserByUid(String uid){
        User user=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            user= queryRunner.query("select * from user where uid=?",uid,new BeanHandler<User>(User.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
