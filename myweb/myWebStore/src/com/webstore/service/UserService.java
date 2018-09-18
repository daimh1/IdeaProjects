package com.webstore.service;

import com.webstore.bean.User;
import com.webstore.dao.UserDao;
import com.webstore.utils.PageHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.webstore.utils.PageHelper.USER_PER_PAGE;

public class UserService {

    public int addUserDao(User user) throws SQLException {
        int ret=0;
        User adminByName = UserDao.findUserByName(user.getUsername());
        if (adminByName!=null){
            ret=-1;//类名相同
        }else{
            if (UserDao.saveUser(user)){
                ret=1 ;//添加成功
            }else{
                ret=-2;//添加失败
            }
        }

        return ret;
    }

    public User adminLogin(String username,String password) throws SQLException {
        /*boolean flag=false;
        if(UserDao.findUserByNameAndPassword(username,password)!=null){
            flag=true;
        }*/
        return UserDao.findUserByNameAndPassword(username,password);
    }

    public boolean modifyadmin(User user,String uid){
        return UserDao.UpdateUser(uid,user);
    }

    public List<User> userList(){return UserDao.findAllUser();}

    public boolean deleteUser(User obj){return UserDao.deleteUserById(obj.getUid());}

    public User findUserByName(String username){return UserDao.findUserByName(username);
    }

    public List<List<User>> userPage(int n){//把product每n项分一组
        List<List<User>> listList=new ArrayList<>();
        List<User> objects=userList();//获取所有类别
        if(objects==null){return null;}//当list为空，返回null
        for(int i=0;i<objects.size();i++){//当list不为空，如果n+1项为空时就不进入循环，让n
            List<User> newobjects=new ArrayList<>();
            while((i+1)%n!=0&&(i+1)<objects.size()){
                newobjects.add(objects.get(i));
                i++;
            }
            newobjects.add(objects.get(i));
            listList.add(newobjects);
        }
        return listList;
    }

    public PageHelper<User> findProductListByPagenumber(String num) throws SQLException {


        //前置信息
        int totalNumber = userList().size();
        int currentPageNumber = Integer.parseInt(num);

        PageHelper<User> pageHelper=new PageHelper<> (currentPageNumber, totalNumber,USER_PER_PAGE);

        //分页也可以内聚到PageHelper里面
        //总的页码数，
        //每一页需要显示的记录数
        /*int recordsNumberPerPage =2;
        int totalPageNumber =( totalNumber%recordsNumberPerPage)==0 ?
                        totalNumber/recordsNumberPerPage :
                        totalNumber/recordsNumberPerPage+1;

        pageHelper.setTotalPageNum(totalPageNumber);*/

        int limit=USER_PER_PAGE;
        int offset= (currentPageNumber-1)*USER_PER_PAGE;
        List<User> objs =userPage(USER_PER_PAGE).get(currentPageNumber-1);
        pageHelper.setRecords(objs);

        return pageHelper;
    }

    public User findUserByUid(String uid){
        return UserDao.findUserByUid(uid);
    }

}
