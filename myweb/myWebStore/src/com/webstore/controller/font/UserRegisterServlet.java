package com.webstore.controller.font;

import com.webstore.bean.User;
import com.webstore.service.UserService;
import com.webstore.utils.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimerTask;

@WebServlet(name = "UserRegisterServlet",urlPatterns = "/UserRegister")
public class UserRegisterServlet extends HttpServlet {

    UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String username=request.getParameter("username");
        String nickname=request.getParameter("nickname");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String birthday=request.getParameter("birthday");

        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        User user=new User(null,username,nickname,password,email,birthday,timestamp.toString());
        try {
            int ret=userService.addUserDao(user);
            if(ret==1){
                SendMail.sendMail(email,"<a href='http://localhost'>点击激活注册账户</a>");
                response.getWriter().println("注册成功！即将跳转首页");
                response.setHeader("refresh","3;url="+request.getContextPath()+"/userlogin.jsp");
            }else if(ret==-1){
                response.sendRedirect("/duplicationname.jsp");
            }else{
                response.sendRedirect("/error.jsp");
            }
        } catch (SQLException e) {
            response.sendRedirect("/error.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
