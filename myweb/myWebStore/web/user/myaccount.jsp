<%@ page import="com.webstore.bean.User" %>
<%@ page import="com.webstore.bean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.OrderService" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/8
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr><td>订单号</td><td>价格</td><td>商品名</td><td>下单状态</td><td>下单时间</td></tr>
    <%
        OrderService orderService=new OrderService();
        User user= (User) session.getAttribute("session_user");
        List<Order> orders=orderService.userOrderList(user.getUid());
        for(int i=0;i<orders.size();i++) {
            out.print("<tr><td>" + orders.get(i).getOid()+"</td><td>"+orders.get(i).getMoney()+"</td><td>"+orders.get(i).getRecipients()+"</td><td>"+orders.get(i).getState()+"</td><td>"+orders.get(i).getOrdertime()+"</td>");
        }
    %>
</table>

</body>
</html>
