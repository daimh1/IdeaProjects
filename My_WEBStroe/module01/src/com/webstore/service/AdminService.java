package com.webstore.service;

import com.webstore.bean.Admin;
import com.webstore.dao.AdminDao;

import java.sql.SQLException;

public class AdminService {


    public int addAdminDao(Admin admin) throws SQLException {
        int ret=0;
        Admin adminByName = AdminDao.findAdminByName(admin.getAdmin_name());
        if (adminByName!=null){
            ret=-1;//类名相同
        }else{
            if (AdminDao.saveAdmin(admin)){
                ret=1 ;//添加成功
            }else{
                ret=-2;//添加失败
            }
        }

        return ret;
    }

    public boolean adminLogin(String username,String password){
        boolean flag=false;
        if(AdminDao.findAdminByNameAndPassword(username,password)!=null){
            flag=true;
        }
        return flag;
    }

    public boolean modifyadmin(Admin admin,String aid){
        return AdminDao.UpdateAdmin(aid,admin);
    }
}
