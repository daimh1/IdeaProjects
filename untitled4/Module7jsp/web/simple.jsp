<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/25
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    当前访问时间是：
    <%
        out.print(new java.util.Date().toLocaleString());
    %>
    <%!
        static {
            System.out.println("jsp声明");
        }
    %>
    <%--
    注释信息
    --%>
    <%--<%@page import="报名" %>
    导包
    --%>
</body>
</html>
