package com.webstore.service;

import com.webstore.bean.Admin;
import com.webstore.dao.AdminDao;

import java.sql.SQLException;
import java.util.List;

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

    public boolean adminLogin(String username,String password) throws SQLException {
        boolean flag=false;
        if(AdminDao.findAdminByNameAndPassword(username,password)!=null){
            flag=true;
        }
        return flag;
    }

    //新修改的用户，要修改的用户id
    public boolean modifyadmin(Admin admin,String aid){
        return AdminDao.UpdateAdmin(aid,admin);
    }

    public List<Admin> findAllAdmin(){
        return AdminDao.findAllAdmin();
    }

    public Admin findAdminById(String id){return AdminDao.findADminById(id);}

}
