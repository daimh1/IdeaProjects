package Test.Servlet;

import Test.Class.MyDataBase;
import Test.Class.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowCart",urlPatterns = "/showCart")
public class ShowCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();

        String productId=request.getParameter("productId");
        ArrayList<Product> shoppingcart=null;
        shoppingcart= (ArrayList<Product>) session.getAttribute("shoppingCart");
       /* int i=0;
        try {
            i=Integer.parseInt(productId);
        }catch (NumberFormatException e){
            response.getWriter().println("参数不正确");
            return;
        }
        Product product=MyDataBase.getProductByPid(i);
        response.getWriter().println("当前购物车上商品的详情是<br><hr>"+product.toString());
        String href=request.getContextPath()+"/addToCart?productId="+productId;
        href=response.encodeURL(href);
        response.getWriter().println("<a href= "+href+">增加到购物车</a>");*/
       if(shoppingcart!=null){
           response.getWriter().println("购物车内商品如下：<br>");
           for(Product p:shoppingcart){
               String deletehref=request.getContextPath()+"/delete?productId="+p.getProductId();
               deletehref=response.encodeURL(deletehref);
               response.getWriter().println(p+"<a href="+deletehref+">删除该商品<a/><br>");
           }
           String href=request.getContextPath()+"/index";
           href=response.encodeURL(href);
           response.getWriter().println("<a href="+href+">首页</a>");
       }else {
           response.getWriter().println("购物车为空！即将跳转到首页");
           String href=request.getContextPath()+"/index";
           System.out.println(href);
           href=response.encodeURL(href);
           System.out.println(href);
           response.setHeader("refresh","3;url="+href);
       }
    }
}
