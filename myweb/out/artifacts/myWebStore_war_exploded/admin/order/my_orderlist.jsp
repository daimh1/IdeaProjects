<%@ page import="com.webstore.bean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.OrderService" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/8
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td></td><td>订单号</td><td>金额</td><td>商品名</td><td>电话</td><td>地址</td><td>支付状态</td><td>订单时间</td><td>用户id</td><td>操作</td>
    </tr>
    <%
        List<Order> orders=null;
        OrderService service=new OrderService();
        orders=service.orderList();

        for(int i=0;i<orders.size();i++){
            out.print("<tr>");
            out.print("<td></td><td>"+orders.get(i).getOid()+"</td><td>"+orders.get(i).getMoney()+"</td><td>"+orders.get(i).getRecipients()+"</td><td>"+orders.get(i).getTel()+"</td><td>"+orders.get(i).getAddress()+"</td><td>"+orders.get(i).getState()+"</td><td>"+orders.get(i).getOrdertime()+"</td><td>"+orders.get(i).getUid()+"</td><td>"+"<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/user/user_modify.jsp?mo="+orders.get(i).getOid()+"'>修改</a></td>");
            out.println("</tr>");
        }

    %>

</table>

</body>
</html>
