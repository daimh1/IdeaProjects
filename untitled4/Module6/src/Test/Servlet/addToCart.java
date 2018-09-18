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

@WebServlet(name = "addToCart",urlPatterns = "/addToCart")
public class addToCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String productId=request.getParameter("productId");
        HttpSession session=request.getSession();
        ArrayList<Product> shoppingCart= (ArrayList<Product>) session.getAttribute("shoppingCart");
        if(shoppingCart==null){
            shoppingCart=new ArrayList<>();
        }
        int i=0;
        try {
            i=Integer.parseInt(productId);
        }catch (NumberFormatException e){
            response.getWriter().println("参数不正确");
            return;
        }

        Product productByProductId=MyDataBase.getProductByPid(i);
        shoppingCart.add(productByProductId);
        session.setAttribute("shoppingCart",shoppingCart);

        response.getWriter().println("增加成功<br>");
        String href=request.getContextPath()+"/showCart";
        System.out.println(href);
        href=response.encodeURL(href);
        System.out.println(href);
        response.getWriter().println("<a href= "+href+">查看购物车！</a><br>");
    }
}
