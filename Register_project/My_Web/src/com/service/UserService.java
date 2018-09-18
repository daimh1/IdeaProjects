package com.service;

import com.dao.UserDao;
import com.dao.daoUtils.DaoSQL;
import com.bean.User;

public class UserService {
    DaoSQL dao =new DaoSQL();

    public int register(User user) {

        int ret=0;

        User userByUserName = dao.findUserByUserName(user.getUsername());

        if (userByUserName!=null){
            ret=-1;
        }else{

            if (dao.saveUser(user)){
                ret=1 ;
            }else{
                ret=-2;
            }
            System.out.println("user="+user);
        }


        return ret;
    }


    //
    public boolean login(String username, String password) {
        return dao.findUserByUseranmeAndPassword(username, password);
    }
}
