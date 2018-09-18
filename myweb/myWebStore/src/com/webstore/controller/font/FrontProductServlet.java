package com.webstore.controller.font;

import com.webstore.bean.Product;
import com.webstore.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FrontProductServlet",urlPatterns = "/frontProduct")
public class FrontProductServlet extends HttpServlet {
    ProductService productService=new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String op = request.getParameter("op");
        //System.out.println(op);
        if(op!=null&&!op.isEmpty()){
            switch (op){
                case "byCid":
                    byCid(request,response);
                    break;
                case "search":
                    search(request,response);
                    break;
                case "findProductById":
                    findProductById(request,response);

            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    public void byCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("cid");
        List<Product> productList=productService.findProductsByCid(cid);
        request.setAttribute("categoryProductList",productList);

        RequestDispatcher rd = request.getRequestDispatcher("/index_category.jsp");

        rd.forward(request,response);


    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pname=request.getParameter("pname");
        List<Product> productList=productService.searchName(pname);
        request.setAttribute("categoryProductList",productList);

        RequestDispatcher rd = request.getRequestDispatcher("/index_category.jsp");

        rd.forward(request,response);
    }
    private void findProductById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("pid");
        Product product=null;
        product=productService.findProductByPId(pid).get(0);

        System.out.println("find");

        request.setAttribute("product",product);
        RequestDispatcher rd = request.getRequestDispatcher("/singleProduct.jsp");

        rd.forward(request,response);
    }
}
