package com.webstore.test;

import com.webstore.bean.Category;
import com.webstore.dao.CategoryDao;
import com.webstore.service.CategoryService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestCatrgory {
    CategoryService categoryService=new CategoryService();
    @Test
    public void test1(){
        Category category=new Category("6","冲饮");

        System.out.println(CategoryDao.saveCategory(category));
    }

    @Test
    public void test2(){
        List<Category> categories=CategoryDao.findAllCategory();
        for(int i=0;i<categories.size();i++){
            System.out.println(categories.get(i));
        }
    }

    @Test
    public void test3(){
        System.out.println(CategoryDao.UpdateCategory("3","坚果炒货"));
    }

    @Test
    public void test4(){
        System.out.println(CategoryDao.deleteCategoryById("7"));
    }

    @Test
    public void test5() throws SQLException {

        Category category=new Category("7","美食推荐");
        System.out.println(categoryService.addCategoryDao(category));
    }

    @Test
    public void test6() throws SQLException {
        Category category=new Category("7","美食推荐");
        System.out.println(categoryService.modifyCategory(category,"美食"));
    }

    @Test
    public void test7(){
        System.out.println(categoryService.categoryPage(6));
    }


}
