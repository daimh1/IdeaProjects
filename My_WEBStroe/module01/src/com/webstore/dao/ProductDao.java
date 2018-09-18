package com.webstore.dao;

import com.webstore.bean.Product;
import com.webstore.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static boolean saveProduct(Product product) {
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());

        try {
            int update = queryRunner.update("insert into product values(?,?,?,?,?,?,?,?)", product.getPid(),product.getPname(),product.getEstoreprice(),product.getMarkprice(),product.getPnum(),product.getCid(),product.getImgurl(),product.getdescibe());
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }

    public static List<Product> findAllProduct(){
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        List<Product> query=null;
        try {
            query=queryRunner.query("select * from product", new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static boolean UpdateProduct(Product newproduct,String pid){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("update product set pname=?,estoreprice=?,markprice=?,pnum=?,cid=?,imgurl=?,descibe=? where pid=?",newproduct.getPname(),newproduct.getEstoreprice(),newproduct.getMarkprice(),newproduct.getPnum(),newproduct.getCid(),newproduct.getImgurl(),newproduct.getdescibe(),pid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public static boolean deleteProductById(String pid){
        boolean flag=false;
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from product where pid=?", pid);
            if (update==1){
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static List<Product> findProductByPid(String pid){
        List<Product> products=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            products= queryRunner.query("select * from product where pid=?",pid,new BeanListHandler<Product>(Product.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<Product> findProductsByName(String pname){
        List<Product> products=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            products= queryRunner.query("select * from product where pname=?",pname,new BeanListHandler<Product>(Product.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    //按类获取商品列表
    public static List<Product> findProductsByCid(String cid){
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        List<Product> query=null;
        try {
            query=queryRunner.query("select * from product where cid=?",cid, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    //价格是闭区间
    public static List<Product> findProductsByPriceSection(String price1,String price2){
        List<Product> products=null;

        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            products= queryRunner.query("select * from product where estoreprice between "+price1+" and "+price2,new BeanListHandler<Product>(Product.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<Product> multiquery(String pid,String pname,String cid,String price1,String price2) throws SQLException {

            //给出sql模板,为了便于后面添加sql语句
            StringBuilder sql = new StringBuilder("select * from product where 1=1");
            //给出parmas
            List<Object> parmas = new ArrayList<Object>();
            QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
            if (pid != null && !pid.trim().isEmpty()) {
                sql.append(" and pid = ?");
                parmas.add(pid);
            }

            if (pname != null && !pname.trim().isEmpty()) {
                sql.append(" and pname like ?");
                parmas.add("%" + pname + "%");
            }


            if (cid != null && !cid.trim().isEmpty()) {
                sql.append(" and cid = ?");
                parmas.add(cid);
            }

            if (price1 == null || price1.trim().isEmpty()) {
                price1 = "0";
            }
            if (price2 == null || price2.trim().isEmpty()) {
                price2 = "999999";
            }
            sql.append(" and estoreprice between ? and ?");
            parmas.add(price1);
            parmas.add(price2);

            return qr.query(sql.toString(), new BeanListHandler<Product>(Product.class), parmas.toArray());


        }
    }