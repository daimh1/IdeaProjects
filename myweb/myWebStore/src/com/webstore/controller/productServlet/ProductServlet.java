package com.webstore.controller.productServlet;

import com.webstore.bean.Category;
import com.webstore.bean.Product;
import com.webstore.dao.ProductDao;
import com.webstore.service.CategoryService;
import com.webstore.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "ProductServlet",urlPatterns = "/Product")
public class ProductServlet extends HttpServlet {
    ProductService productService=new ProductService();
    CategoryService categoryService=new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");
        //System.out.println(op);
        if(op!=null&&!op.isEmpty()){
            //System.out.println(2);
            switch (op){
                case "add":
                    //System.out.println(1);
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
        //response.sendRedirect("/admin/product/productlist.jsp");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid=request.getParameter("search_pid");
        String pname=request.getParameter("search_pname");
        String cid=request.getParameter("search_cid");
        String price1=request.getParameter("search_price1");
        String price2=request.getParameter("search_price2");
        //System.out.println(pid+pname+cid+price1+price2);

        try {
            List<Product> products=productService.multsearch(pid,pname,cid,price1,price2);
            //System.out.println(products);
            request.setAttribute("productlist",products);
            RequestDispatcher rd = request.getRequestDispatcher("/admin/product/search_result.jsp");//转发时，路径不要带项目名
            rd.forward(request, response);

        } catch (SQLException e) {
            response.sendRedirect("/error.jsp");
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pid=request.getParameter("pid");
        String pnum=request.getParameter("pnum");
        String pname=request.getParameter("pname");
        String estorePrice=request.getParameter("estorePrice");
        String markPrice=request.getParameter("markPrice");
        String imgUrl=request.getParameter("imgUrl");
        String cid=request.getParameter("cid");
        String description=request.getParameter("description");

        Product product=new Product(pid,pname,estorePrice,markPrice,pnum,cid,imgUrl,description);
        try {
            productService.modifyProduct(product,pid);
            //response.sendRedirect("/admin/category/category.jsp");
            response.getWriter().println("修改成功！");
            response.setHeader("refresh","1;url="+request.getContextPath()+"/admin/product/productlist.jsp");


        }catch (Exception e){
            response.sendRedirect("/error.jsp");
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String de = request.getParameter("de");

        try {
            productService.deleteProduct(productService.findProductByPId(de).get(0));
            response.sendRedirect("/admin/product/productlist.jsp");
        }catch (Exception e){
            response.sendRedirect("/error.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pname=request.getParameter("pname");
        String estoreprice=request.getParameter("estoreprice");
        String markprice=request.getParameter("markprice");
        String pnum=request.getParameter("pnum");
        String cname=request.getParameter("cname");
        //String imgurl=request.getParameter("imgurl");
        String descibe=request.getParameter("descibe");
        String cid=null;
        try {
            cid=categoryService.getCategoryByName(cname).getCid();
        } catch (Exception e) {//如果不存在，创建该类别
            try {
                categoryService.addCategoryDao(new Category(null,cname));
                cid=categoryService.getCategoryByName(cname).getCid();
            } catch (SQLException e1) {
                response.sendRedirect("/error.jsp");
            }
        }
        Product product=new Product(null,pname,estoreprice,markprice,pnum,cid,null,descibe);

        boolean ret=productService.addProduct(product);

        if(ret){
            response.sendRedirect("/admin/product/productlist.jsp");
       }else {
            response.sendRedirect("/error.jsp");
        }


    }

}
