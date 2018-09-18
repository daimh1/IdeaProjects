<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="8kb" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/template/header.jsp" %>



<h2>aaaa</h2>

<%

    int x=2;

    //第一个
    String contextPath = request.getContextPath();

    //第二个
    response.getWriter().println("aa");

    //第三个config
    String encoding = config.getInitParameter("encoding");

    out.println("encoding="+encoding);

    //第四个ServletContext 全局域（任意一个jsp或者serlvet设置，在另一个都可以获取）
    application.setAttribute("account",100);


    session.setAttribute("user","zhangsan");



%>

<%@include file="/template/footer.jspf"%>

</body>
</html>
