package com.webstore.service;

import com.webstore.bean.Product;
import com.webstore.dao.ProductDao;
import com.webstore.utils.PageHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.webstore.utils.PageHelper.PRODUCT_PER_PAGE;

public class ProductService {
    public boolean addProduct(Product obj){
        if(obj.getPid()==null) {
            obj.setPid(UUID.randomUUID().toString().replaceAll("-", ""));//给商品编号
        }
        return ProductDao.saveProduct(obj);
    }

    public List<Product> productList(){
        return ProductDao.findAllProduct();
    }

    
    public boolean deleteProduct(Product obj){
        return ProductDao.deleteProductById(obj.getPid());
    }

    public boolean modifyProduct(Product obj,String id){
        boolean ret=false;
            if (ProductDao.UpdateProduct(obj, id)) {
                ret = true;
            }
        return ret;
    }

    public List<Product> findProductByPId(String pid){
        return ProductDao.findProductByPid(pid);
    }

    /**public List<Product> findProductsByPriceSection(String price1,String price2){
        return ProductDao.findProductsByPriceSection(price1,price2);
    }*/

    public List<Product> findProductsByCid(String cid){
        return ProductDao.findProductsByCid(cid);
    }

    public List<Product> findProductsByName(String pname){
        return ProductDao.findProductsByName(pname);
    }

    public List<Product> multsearch(String pid,String pname,String cid,String price1,String price2) throws SQLException {
        return ProductDao.multiquery(pid,pname,cid,price1,price2);
    }

    public List<List<Product>> productPage(int n){//把product每n项分一组
        List<List<Product>> listList=new ArrayList<>();
        List<Product> objects=productList();//获取所有类别
        if(objects==null){return null;}//当list为空，返回null
        for(int i=0;i<objects.size();i++){//当list不为空，如果n+1项为空时就不进入循环，让n
            List<Product> newobjects=new ArrayList<>();
            while((i+1)%n!=0&&(i+1)<objects.size()){
                newobjects.add(objects.get(i));
                i++;
            }
            newobjects.add(objects.get(i));
            listList.add(newobjects);
        }
        return listList;
    }

    public PageHelper<Product> findProductListByPagenumber(String num) throws SQLException {


        //前置信息
        int totalNumber = productList().size();
        int currentPageNumber = Integer.parseInt(num);

        PageHelper<Product> pageHelper=new PageHelper<> (currentPageNumber, totalNumber,PRODUCT_PER_PAGE);

        //分页也可以内聚到PageHelper里面
        //总的页码数，
        //每一页需要显示的记录数
        /*int recordsNumberPerPage =2;
        int totalPageNumber =( totalNumber%recordsNumberPerPage)==0 ?
                        totalNumber/recordsNumberPerPage :
                        totalNumber/recordsNumberPerPage+1;

        pageHelper.setTotalPageNum(totalPageNumber);*/

        int limit=PRODUCT_PER_PAGE;
        int offset= (currentPageNumber-1)*PRODUCT_PER_PAGE;
        List<Product> objs =productPage(PRODUCT_PER_PAGE).get(currentPageNumber-1);
        pageHelper.setRecords(objs);

        return pageHelper;
    }

    public List<Product> searchName(String pname){
        return ProductDao.namequery(pname);
    }
}
