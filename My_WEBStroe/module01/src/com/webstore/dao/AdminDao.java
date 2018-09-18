package com.webstore.dao;

import com.webstore.bean.Admin;
import com.webstore.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDao {
    public static boolean saveAdmin(Admin admin) {
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("insert into admin_account values(?,?,?)", admin.getAdmin_id(),admin.getAdmin_name(),admin.getAdmin_password());
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

    public static List<Admin> findAllAdmin(){
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        List<Admin> query=null;
        try {
            query=queryRunner.query("select * from admin_account", new BeanListHandler<Admin>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static boolean UpdateAdmin(String admin_id, Admin admin){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("update admin_account set admin_name=?,admin_password=? where admin_id=?",admin.getAdmin_name(),admin.getAdmin_password(),admin_id);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Admin findAdminByNameAndPassword(String username,String password){
        Admin admin=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            admin= queryRunner.query("select * from admin_account where admin_name='"+username+"' and admin_password='"+password+"'",new BeanHandler<Admin>(Admin.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public static Admin findAdminByName(String username){
        Admin admin=null;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());

        try {
            admin=queryRunner.query("select * from admin_account where admin_name=?",username,new BeanHandler<Admin>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }

    public static boolean afe(){
        return false;
    }
}
