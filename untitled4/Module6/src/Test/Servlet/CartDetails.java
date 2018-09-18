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

@WebServlet(name = "CartDetails",urlPatterns = "/details")
public class CartDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String productId=request.getParameter("productId");
        int i=0;
        try {
            i=Integer.parseInt(productId);
        }catch (NumberFormatException e){
            response.getWriter().println("参数不正确");
            return;
        }
        Product product=MyDataBase.getProductByPid(i);
        response.getWriter().println("当前购物车上的商品详情是<br><hr>"+product.toString());
        String href=request.getContextPath()+"/addToCart?productId="+productId;
        href=response.encodeURL(href);
        response.getWriter().println("<a href= "+href+" >增加到购物车</a>");
    }
}
