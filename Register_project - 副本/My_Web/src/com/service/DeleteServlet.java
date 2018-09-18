package com.service;

import com.dao.daoUtils.DaoSQL;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");


        String de = request.getParameter("de");

        int n=Integer.valueOf(de);

        System.out.println(n);

        HttpSession session=request.getSession();
        List<User> users= (List<User>) session.getAttribute("queryResult");

        //删除list第n个位置元素
        DaoSQL.deleteUserByUserName(users.get(n).getUsername());

        response.getWriter().println("删除成功！即将 跳转到首页！");


        response.setHeader("refresh","3;url="+request.getContextPath()+"/index.jsp");




        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
