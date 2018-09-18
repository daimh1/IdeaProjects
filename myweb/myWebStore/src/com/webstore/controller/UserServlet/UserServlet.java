package com.webstore.controller.UserServlet;

import com.webstore.bean.User;
import com.webstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "UserServlet",urlPatterns = "/User")
public class UserServlet extends HttpServlet {

    UserService service=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");

        if (op != null) {
            switch (op) {
                case "add":
                    add(request, response);
                    break;
                case "modify":
                    modify(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "search":
                    search(request, response);
                    break;
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String birthday=request.getParameter("birthday");
        Date date=new Date();
        String registertime=new Timestamp(date.getTime()).toString();

        User user=new User(null,username,nickname,password,email,birthday,registertime);

        try {
            int ret=service.addUserDao(user);
            if(ret==-1){
                response.sendRedirect("/duplicationname.jsp");
            }else if(ret==1){
                response.sendRedirect("/admin/user/userlist.jsp");
            }else{
                response.sendRedirect("/error.jsp");
            }
        } catch (SQLException e) {
            response.sendRedirect("/error.jsp");
        }
    }
    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid=request.getParameter("uid");
        String username=request.getParameter("username");
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String birthday=request.getParameter("birthday");
        User user=new User(uid,username,nickname,password,email,birthday,null);
        if(service.modifyadmin(user,uid)){
            try {
                response.getWriter().println("修改成功！");
            } catch (IOException e) {
                response.sendRedirect("/error.jsp");
            }
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
        }else {
            response.sendRedirect("/error.jsp");
        }



        // String
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid=request.getParameter("uid");
        User user=service.findUserByUid(uid);
        service.deleteUser(user);

        response.getWriter().println("修改成功！");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
    }
    private void search(HttpServletRequest request, HttpServletResponse response){

    }


}
