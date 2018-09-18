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

@WebServlet(name = "DeleteProduct",urlPatterns = "/delete")
public class DeleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String productId=request.getParameter("productId");
        int i=0;
        try {
            i=Integer.parseInt(productId);
        }catch (NumberFormatException e){
            response.getWriter().println("参数不正确");
            return;
        }
        Product productById=MyDataBase.getProductByPid(i);
        HttpSession session=request.getSession();
        ArrayList<Product> shoppingCart= (ArrayList<Product>) session.getAttribute("shoppingCart");
        if(shoppingCart!=null){
            shoppingCart.remove(productById);
            response.getWriter().println("删除成功<br>");
            String href=request.getContextPath()+"/showCart";
            href=response.encodeURL(href);
            response.getWriter().println("<a href="+href+">查看购物车");
        }else {
            response.getWriter().println("购物车为空！即将跳转到首页");
            String href=request.getContextPath()+"/index";
            href=response.encodeURL(href);
            response.setHeader("refresh","3;url="+href);
        }
    }
}
