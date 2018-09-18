package com.webstore.dao;

import com.webstore.utils.DBCPUtils;
import com.webstore.bean.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {

    public static boolean saveCategory(Category category) {
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("insert into category values(?,?)", category.getCid(),category.getCname());
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

    public static List<Category> findAllCategory(){
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        List<Category> query=null;
        try {
            query=queryRunner.query("select * from category", new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static boolean UpdateCategory(String cid,String cname){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("update category set cname=? where cid=?", cname,cid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteCategoryById(String cid){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from category where cid=?", cid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static Category findCatergoryByName(String cname) throws SQLException{
        Category category=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        category= queryRunner.query("select * from category where cname=?",cname,new BeanHandler<Category>(Category.class));

        return category;
    }

    public static Category findCatergoryByCid(String cid){
        Category category=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            category= queryRunner.query("select * from category where cid=?",cid,new BeanHandler<Category>(Category.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }




}
