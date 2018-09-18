<%@ page import="com.webstore.service.OrderService" %>
<%@ page import="com.webstore.bean.Order" %><%--
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
<%
    OrderService service=new OrderService();
    String mo=request.getParameter("mo");
    Order order=service.findOrderByOid(mo);

    request.setAttribute("oid",order.getOid());
    request.setAttribute("money",order.getMoney());
    request.setAttribute("recipients",order.getRecipients());
    request.setAttribute("tel",order.getTel());
    request.setAttribute("address",order.getAddress());
    request.setAttribute("state",order.getState());
    request.setAttribute("ordertime",order.getOrdertime());
    request.setAttribute("uid",order.getUid());

%>
<form action="/Order?op=modify" method="post">
    <table>
        <tr><td>订单号</td><td><input type="text" name="oid" value="${oid}" readonly="readonly"></td></tr>
        <tr><td>金额</td><td><input type="text" name="money" value="${money}"></td></tr>
        <tr><td>收货人</td><td><input type="text" name="recipients" value="${recipients}"></td></tr>
        <tr><td>电话</td><td><input type="text" name="tel" value="${tel}"></td></tr>
        <tr><td>地址</td><td><input type="text" name="address" value="${address}"></td></tr>
        <tr><td>支付状态</td><td><input type="text" name="state" value="${state}"></td></tr>
        <tr><td>订单时间</td><td><input type="text" name="ordertime" value="${ordertime}" readonly="readonly"></td></tr>
        <tr><td>用户id</td><td><input type="text" name="uid" value="${uid}"></td></tr>

    </table>
    <input type="submit" value="修改">
</form>

</body>
</html>
