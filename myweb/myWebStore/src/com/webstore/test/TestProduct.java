package com.webstore.test;

import com.webstore.bean.Product;
import com.webstore.dao.ProductDao;
import com.webstore.service.ProductService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class TestProduct {
    ProductService service=new ProductService();

    @Test
    public void test1() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Product product = new Product(uuid, "木瓜干 158克", "20", "20", "100", "1", "", "品名 木瓜干 158克\n" +
                "产地 福建省漳州市净含量158克\n" +
                "配料 木瓜、白砂糖、麦芽糖浆、食品添加剂（柠檬酸、焦亚硫酸钠）、食品用香精香料\n" +
                "保质期 9个月\n" +
                "温馨提示\n" +
                "1、网易严选出售的食品，除明确质量问题外均不接受退换货\n" +
                "2、请置于阴凉避光、通风、干燥处");
        System.out.println(ProductDao.saveProduct(product));
    }

    @Test
    public void test2(){
        List<Product> products=ProductDao.findAllProduct();
        for(int i=0;i<products.size();i++){
            System.out.println(products.get(i));
        }
    }

    @Test
    public void test3(){
        Product product = new Product(null, "草莓干 118克", "20", "20", "100", "4", "", "\n" +
                "品名 草莓干118克\n" +
                "产地 福建省漳州市\n" +
                "净含量 118克\n" +
                "配料 草莓、白砂糖、食用盐、食品添加剂（柠檬酸、焦亚硫酸钠、胭脂红）、食品用香精香料\n" +
                "保质期 9个月\n" +
                "温馨提示\n" +
                "1、网易严选出售的食品，除明确质量问题外均不接受退换货\n" +
                "2、请置于阴凉避光、通风、干燥处");


        System.out.println(ProductDao.UpdateProduct(product,"aa1123a73fd0446bbd8bd8b227d8d9a5"));
    }

    @Test
    public void test4(){
        System.out.println(ProductDao.deleteProductById("da2f201218d14c22810e24bb88c3e38d"));
    }

    @Test
    public void test5(){
        System.out.println(ProductDao.findProductsByName("木瓜干 158克"));
    }

    @Test
    public void test6(){
        System.out.println(ProductDao.findProductsByCid("4"));
    }

    @Test
    public void test7(){
        System.out.println(ProductDao.findProductsByPriceSection("20","20"));//闭区间查询
    }

    @Test
    public void test8(){
        Product product = new Product(null, "草莓干 118克", "20", "20", "100", "4", "", "\n" +
                "品名 草莓干118克\n" +
                "产地 福建省漳州市\n" +
                "净含量 118克\n" +
                "配料 草莓、白砂糖、食用盐、食品添加剂（柠檬酸、焦亚硫酸钠、胭脂红）、食品用香精香料\n" +
                "保质期 9个月\n" +
                "温馨提示\n" +
                "1、网易严选出售的食品，除明确质量问题外均不接受退换货\n" +
                "2、请置于阴凉避光、通风、干燥处");
        System.out.println(service.addProduct(product));
    }
    @Test
    public void test9() throws SQLException {

        System.out.println(ProductDao.multiquery(null,"18克",null,"17",null));
    }

}
