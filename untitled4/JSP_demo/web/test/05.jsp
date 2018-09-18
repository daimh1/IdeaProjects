<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Object account = application.getAttribute("account");

    out.println(account);

    application.removeAttribute("account");


    Object username = session.getAttribute("user");


    Object name = pageContext.getAttribute("name");

    out.println("name="+name);
%>

用户名：<%=username%>

</body>
</html>
