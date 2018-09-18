<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="iso-8859-1" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%="你好"%>
<%
    out.println("bbb");

    response.getWriter().println("123123");

%>

<%="eeefff"%>
<%
    response.getWriter().println("ccc");
%>

</body>
</html>
