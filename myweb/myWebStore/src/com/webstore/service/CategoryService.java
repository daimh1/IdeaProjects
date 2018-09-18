package com.webstore.service;

import com.webstore.bean.Category;
import com.webstore.dao.CategoryDao;
import com.webstore.utils.PageHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.webstore.utils.PageHelper.CATEGORY_PER_PAGE;


public class CategoryService {

    public int addCategoryDao(Category category) throws SQLException {
        int ret=0;
        Category catergoryByName = CategoryDao.findCatergoryByName(category.getCname());
        if (catergoryByName!=null){
            ret=-1;//类名相同
        }else{
            if (CategoryDao.saveCategory(category)){
                ret=1 ;//添加成功
            }else{
                ret=-2;//添加失败
            }
        }
        return ret;
    }

    public int modifyCategory(Category category,String cname) throws SQLException {
        int ret=0;
        if(CategoryDao.findCatergoryByName(cname)!=null){
            ret=-1;
        }else {
            if (CategoryDao.UpdateCategory(category.getCid(), cname)) {
                ret = 1;
            } else {
                ret = -1;
            }
        }
        return ret;
    }

    public boolean deleteCategory(String cid){
        return CategoryDao.deleteCategoryById(cid);
    }

    public List<Category> categoryList(){
        return CategoryDao.findAllCategory();
    }
    public Category getCategoryByName(String cname) throws SQLException {
        return CategoryDao.findCatergoryByName(cname);
    }

    //分页方法
    public List<List<Category>> categoryPage(int n){//把category每n项分一组
        List<List<Category>> listList=new ArrayList<>();
        List<Category> categories=categoryList();//获取所有类别
        if(categories==null){return null;}//当list为空，返回null
        for(int i=0;i<categories.size();i++){//当list不为空，如果n+1项为空时就不进入循环，让n
            List<Category> newcategories=new ArrayList<>();
            while((i+1)%n!=0&&(i+1)<categories.size()){
                newcategories.add(categories.get(i));
                i++;
            }
            newcategories.add(categories.get(i));
            listList.add(newcategories);
        }
        return listList;
    }

    public Category getCategoryByCid(String cid){
        return CategoryDao.findCatergoryByCid(cid);
    }

    public PageHelper<Category> findCategoryListByPagenumber(String num) throws SQLException {


        //前置信息
        int totalNumber = CategoryDao.findAllCategory().size();
        int currentPageNumber = Integer.parseInt(num);

        PageHelper<Category> pageHelper=new PageHelper<> (currentPageNumber, totalNumber,CATEGORY_PER_PAGE);

        //分页也可以内聚到PageHelper里面
        //总的页码数，
        //每一页需要显示的记录数
        /*int recordsNumberPerPage =2;
        int totalPageNumber =( totalNumber%recordsNumberPerPage)==0 ?
                        totalNumber/recordsNumberPerPage :
                        totalNumber/recordsNumberPerPage+1;

        pageHelper.setTotalPageNum(totalPageNumber);*/

        int limit=CATEGORY_PER_PAGE;
        int offset= (currentPageNumber-1)*CATEGORY_PER_PAGE;
        List<Category> categories =categoryPage(CATEGORY_PER_PAGE).get(currentPageNumber-1);
        pageHelper.setRecords(categories);

        return pageHelper;
    }


}
