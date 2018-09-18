package com.webstore.controller.font;

import com.webstore.bean.Product;
import com.webstore.bean.ShoppingCart;
import com.webstore.dao.ProductDao;
import com.webstore.service.ShoppingCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet",urlPatterns = "/addtocart")
public class AddToCartServlet extends HttpServlet {
    ShoppingCartService service=new ShoppingCartService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");
        //System.out.println(op);
        if (op != null && !op.isEmpty()) {
            switch (op) {
                case "add":
                    add(request,response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid=request.getParameter("pid");
        String uid=request.getParameter("uid");
        String buynum=request.getParameter("buynum");
        //System.out.println(buynum);
        if(buynum==null){buynum="1";}

        ShoppingCart preshoppingCart=service.findShoppingcartByUidAndPid(uid,pid);
        if(preshoppingCart==null) {
            ShoppingCart shoppingCart = new ShoppingCart(null, uid, pid, "0");
            service.addShoppingCart(shoppingCart);
            ShoppingCart cart=service.findShoppingcartByUidAndPid(uid,pid);
            service.addnumById(buynum,cart.getId(),pid);
        }else{
            service.addnumById(buynum,preshoppingCart.getId(),pid);
        }
        response.getWriter().println("购物车加入成功！");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/user/shoppingcart.jsp");
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imgid=request.getParameter("imgid");
        String pid=ProductDao.findpidbyimgurl(imgid);
        String uid=request.getParameter("uid");
        String num=request.getParameter("num");


        ShoppingCart shoppingCart=service.findShoppingcartByUidAndPid(uid,pid);

        if(service.removeShoppingCart(shoppingCart.getId(),pid,num)) {
            response.getWriter().println("删除成功！");
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/user/shoppingcart.jsp");
        }else{
            response.getWriter().println("操作失败！");
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/user/shoppingcart.jsp");
        }
    }
}
