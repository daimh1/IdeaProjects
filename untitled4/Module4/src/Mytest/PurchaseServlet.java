package Mytest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet",urlPatterns = "/purchaseServlet")
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        if(id==null){
            String url="/demo2";
            response.sendRedirect(url);
            return;
        }
        Book book=BookDB.getBook(id);

        HttpSession session=request.getSession();
        List<Book> cart=(List)session.getAttribute("cart");
        if(cart==null){
            cart=new ArrayList<Book>();
            session.setAttribute("cart",cart);
        }
        cart.add(book);
        Cookie cookie=new Cookie("JESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("/");
        response.addCookie(cookie);

        String url="/cartServlet";
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
