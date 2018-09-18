package com.webstore.controller.font;

import com.webstore.bean.User;
import com.webstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserLoginServlet",urlPatterns = "/userLogin")
public class UserLoginServlet extends HttpServlet {
    UserService service=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        this.login(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean flag=false;
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        try {
            User user=service.adminLogin(username,password);
            if(user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("session_user",user);
                session.setAttribute("session_user_name",username);

                response.getWriter().println("登录成功！即将跳转到首页页面");
                response.setHeader("refresh","1;url="+request.getContextPath()+"/index.jsp");
            }else {
                response.sendRedirect("/failed_login.jsp");
            }

        } catch (SQLException e) {
            response.sendRedirect("/error.jsp");
        }
    }
}
