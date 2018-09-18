package com.webstore.controller.adminServlet;

import com.webstore.bean.Admin;
import com.webstore.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet",urlPatterns = "/Admin")
public class AdminServlet extends HttpServlet {

    AdminService service=new AdminService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");
        //System.out.println(op);
        if(op!=null&&!op.isEmpty()){
            switch (op){
                case "add":
                    add(request,response);
                    break;
                case "modify":
                    modify(request,response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
                case "logout":
                    logout(request,response);
                    break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String admin_name=request.getParameter("admin_name");
        String admin_password=request.getParameter("admin_password");
        String admin_password2=request.getParameter("admin_password2");
        if(!admin_password.equals(admin_password2)){
            response.getWriter().println("两次输入密码不一致，即将返回首页！");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/admin/admin_account/admin_add.jsp");
            return;
        }
        Admin admin=new Admin(null,admin_name,admin_password);

        try {
            int ret=service.addAdminDao(admin);
            if(ret==-1){
                response.sendRedirect("/duplicationname.jsp");
            }else if(ret==1){
                response.sendRedirect("/admin/admin_account/adminlist.jsp");
            }else{
                response.sendRedirect("/error.jsp");
            }
        } catch (SQLException e) {
            response.sendRedirect("/error.jsp");
        }
    }

    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String admin_id=request.getParameter("admin_id");
        String admin_name=request.getParameter("admin_name");
        String admin_password=request.getParameter("admin_password");
        String admin_password2=request.getParameter("admin_password2");

        if(!admin_password.equals(admin_password2)){
            response.getWriter().println("两次输入密码不一致，即将返回首页！");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/admin/admin_account/adminlist.jsp");
            return;
        }

        Admin admin=new Admin(admin_id,admin_name,admin_password);

        if(service.modifyadmin(admin,admin_id)) {
            //System.out.println(product);
            response.getWriter().println("修改成功！");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/admin/admin_account/adminlist.jsp");

            //response.sendRedirect("/admin/admin_account/adminlist.jsp");
        }else{
            response.sendRedirect("/error.jsp");
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response){
        String de = request.getParameter("de");

    }
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session!=null){
            session.invalidate();
            response.getWriter().println("注销成功！即将 跳转到首页！");
        }
        response.setHeader("refresh","3;url="+request.getContextPath()+"/index.jsp");
    }


}
