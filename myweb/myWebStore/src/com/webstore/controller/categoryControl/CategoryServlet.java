package com.webstore.controller.categoryControl;

import com.webstore.bean.Category;
import com.webstore.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryServlet",urlPatterns = "/Category")
public class CategoryServlet extends HttpServlet {
    CategoryService service = new CategoryService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");

        if (op != null && !op.isEmpty()) {
            switch (op) {
                case "add":
                    add(request,response);
                    break;
                case "modify":
                    modify(request,response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
                case "search":
                    search(request,response);
                    break;

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cname=request.getParameter("cname");
        Category category=new Category(null,cname);
        try {
            int ret=service.addCategoryDao(category);
            if(ret==1)
            {response.sendRedirect("/admin/category/category.jsp");}
            else if(ret==-1){
                response.sendRedirect("/duplicationname.jsp");
            }else {
                response.sendRedirect("/error.jsp");
            }
        }catch (Exception e){
            response.sendRedirect("/error.jsp");
        }
    }


    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pre_cname=request.getParameter("pre_cname");//要修改的类别名
        String cname=request.getParameter("cname");//修改后的类别名
        try {
            service.modifyCategory(service.getCategoryByName(pre_cname),cname);
            response.sendRedirect("/admin/category/category.jsp");
        }catch (Exception e){
            response.sendRedirect("/error.jsp");
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/admin/category/category.jsp");

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String de = request.getParameter("de");
        CategoryService service=new CategoryService();
        try {
            service.deleteCategory(de);
            response.sendRedirect("/admin/category/category.jsp");
        }catch (Exception e){
            response.sendRedirect("/error.jsp");
        }
    }
}