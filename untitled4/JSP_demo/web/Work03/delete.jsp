<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");
    session.setAttribute("username",null);
    session.setAttribute("password",null);

    out.println("您已注销！即将跳转到首页");
    String href=request.getContextPath()+"/Work03/login.html";
    System.out.println(href);
    href=response.encodeURL(href);
    System.out.println(href);
    response.setHeader("refresh","3;url="+href);
%>

</body>
</html>
