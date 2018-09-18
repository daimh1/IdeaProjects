package com.webstore.controller.font;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");
        //System.out.println(op);
        if (op != null && !op.isEmpty()) {
            //System.out.println(2);
            switch (op) {
                case "findCart":
                    //System.out.println(1);
                    findCart(request, response);
                    break;
            }
        }

    }
    //重定向到购物车列表
    private void findCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("session_user")==null){
            response.getWriter().println("请先登录");
            response.setHeader("refresh","1;url="+request.getContextPath()+"/index.jsp");
        }else{
        response.sendRedirect(request.getContextPath()+"/user/shoppingcart.jsp");}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
