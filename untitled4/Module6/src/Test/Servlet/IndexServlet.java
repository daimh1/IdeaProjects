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

@WebServlet(name = "IndexServlet",urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        response.getWriter().println("<h1 align='center'>京西商城</h1>");
        response.getWriter().println("<hr>");
        response.getWriter().println("本商城的所有商品列表如下:<br>");

        ArrayList<Product> products=MyDataBase.getAllProduct();
        for(Product p:products){
            String href=request.getContextPath()+"/details?productId="+p.getProductId();
            href=response.encodeURL(href);
            response.getWriter().println("<a href="+href+">"+p.getProductName()+"</a><br>");

        }
        String href=request.getContextPath()+"/showCart";
        href=response.encodeURL(href);
        response.getWriter().println("<br><br><a href= "+href+">查看购物车</a><br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
