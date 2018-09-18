package com.webstore.controller.font;

import com.webstore.bean.User;
import com.webstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxServlet",urlPatterns = "/Ajax")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        //System.out.println(username);
        UserService userService=new UserService();
        User userByName = userService.findUserByName(username);
        //System.out.println(userByName);
        if(userByName==null){
            response.getWriter().print("valid");
        }else {
            response.getWriter().print("<xml><user></user></xml>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
