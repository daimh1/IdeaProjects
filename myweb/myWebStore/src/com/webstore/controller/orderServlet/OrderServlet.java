package com.webstore.controller.orderServlet;

import com.webstore.bean.*;
import com.webstore.dao.ShoppingCartDao;
import com.webstore.service.OrderService;
import com.webstore.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderServlet",urlPatterns = "/Order")
public class OrderServlet extends HttpServlet {

    OrderService service=new OrderService();
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
                case "addshoppingcart":
                    addshoppingcart(request,response);
                    break;

            }
        }
    }

    private void addshoppingcart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        ProductService productService=new ProductService();
        List<CartList> cartLists= (List<CartList>) session.getAttribute("shoppingCart");
        User user= (User) session.getAttribute("session_user");

        Productlist productlist=new Productlist();
        productlist.productidList=new ArrayList<>();
        productlist.productNum=new ArrayList<>();
        productlist.oidList=new ArrayList<>();



        for(int i=0;i<cartLists.size();i++){
            Order order=new Order();
            order.setOid(UUID.randomUUID().toString().replaceAll("-", ""));
            order.setMoney(String.valueOf(cartLists.get(i).getTotalprice()));
            order.setUid(user.getUid());
            order.setState("1");
            Date date=new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            order.setOrdertime(timeStamp.toString());
            service.addOrder(order);

            productlist.productidList.add(productService.findProductsByName(cartLists.get(i).getDescribtion()).get(0).getPid());
            productlist.productNum.add(cartLists.get(i).getNum());
            productlist.oidList.add(order.getOid());


        }
        session.setAttribute("productlist",productlist);

        ShoppingCartDao.deleteAllShoppingCart();
        response.getWriter().println("下单成功！即将跳转到订单列表");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/user/mylist.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid=request.getParameter("pid");
        String uid=request.getParameter("uid");
        ProductService productService=new ProductService();
        Product product=productService.findProductByPId(pid).get(0);
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        Order order=new Order(null,product.getEstoreprice(),product.getPname(),null,null,"1",timeStamp.toString(),uid);
        service.addOrder(order);

        response.getWriter().println("下单成功！即将跳转到首页页面");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/index.jsp");
    }

    private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oid=request.getParameter("oid");
        String money=request.getParameter("money");
        String recipients=request.getParameter("recipients");
        String tel=request.getParameter("tel");
        String address=request.getParameter("address");
        String state=request.getParameter("state");
        String ordertime=request.getParameter("ordertime");
        String uid=request.getParameter("uid");

        Order order=new Order(oid,money,recipients,tel,address,state,ordertime,uid);

        if(service.modifyOrder(order,oid)){
            response.getWriter().println("修改成功！即将跳转到首页页面");
            response.setHeader("refresh","1;url="+request.getContextPath()+"/admin/order/orderlist.jsp");
        }else{
            response.getWriter().println("修改失败！即将跳转到首页页面");
            response.setHeader("refresh","1;url="+request.getContextPath()+"/admin/order/orderlist.jsp");
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String oid=request.getParameter("oid");
        String state=request.getParameter("state");
        ProductService productservice=new ProductService();

        HttpSession session=request.getSession();

        Productlist productlist= (Productlist) session.getAttribute("productlist");
        for(int i=0;i<productlist.productNum.size();i++){
            if(productlist.oidList.get(i).equals(oid)){
            service.addPnum(productlist.productidList.get(i),productlist.productNum.get(i));}
        }

        if(service.deleteOrder(oid)) {
            response.getWriter().println("删除成功！即将跳转到首页页面");
            response.setHeader("refresh", "1;url=" + request.getContextPath() + "/index.jsp");
        }else {
            response.sendRedirect("/errror.jsp");
        }
    }
}
