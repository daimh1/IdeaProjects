package com.webstore.service;

import com.webstore.bean.CartList;
import com.webstore.bean.ShoppingCart;
import com.webstore.dao.ProductDao;
import com.webstore.dao.ShoppingCartDao;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {

    public boolean addShoppingCart (ShoppingCart shoppingCart){

        return ShoppingCartDao.addShoppingCart(shoppingCart);
    }

    public boolean removeShoppingCart(String id,String pid,String num){
        ProductDao.pluspnumByPid(num,pid);
        return ShoppingCartDao.removeShoppingCart(id);
    }

    public List<CartList> cartLists(String uid){
        List<CartList> cartLists=new ArrayList<>();
        List<ShoppingCart> shoppingCarts=ShoppingCartDao.shoppingCartListByUser(uid);

        for(int i=0;i<shoppingCarts.size();i++){
            String imgurl=ProductDao.findProductByPid(shoppingCarts.get(i).getPid()).get(0).getImgurl();
            String describtion=ProductDao.findProductByPid(shoppingCarts.get(i).getPid()).get(0).getPname();
            String pnum=shoppingCarts.get(i).getPnum();
            int num=Integer.parseInt(pnum);
            String perprice=ProductDao.findProductByPid(shoppingCarts.get(i).getPid()).get(0).getEstoreprice();
            double per_price=Double.parseDouble(perprice);
            double totalprice=per_price*num;

            CartList cartList=new CartList(imgurl,describtion,pnum,perprice,totalprice);

            cartLists.add(cartList);
        }

        return cartLists;
    }

    public ShoppingCart findShoppingcartByUidAndPid(String uid,String pid){

        return ShoppingCartDao.shoppingCartByUidAndPid(uid,pid);
    }

    public boolean addnumById(String num,String id,String pid){
        ProductDao.reducepnumByPid(num,pid);
        return ShoppingCartDao.addnum(num,id);
    }


    public boolean deleteCart(String num,String pid){
        ProductDao.pluspnumByPid(num,pid);
        return ShoppingCartDao.removeShoppingCart(pid);
    }

    public boolean deleteAllCart(){
        return ShoppingCartDao.deleteAllShoppingCart();
    }

}
