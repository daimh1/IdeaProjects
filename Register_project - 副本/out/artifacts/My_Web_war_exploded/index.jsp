<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.model.User" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/2
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  </head>
  <body>

  <h1>Hello World</h1>
  <hr>


  <c:choose>
    <c:when test="${! empty session_username}">
      <h4>欢迎您,${session_username}!<br><br>您的账号信息如下：</h4>
      <table class="table table-bordered table-striped">
      <tr> <td>username</td> <td>password</td><td>age</td></tr>
      <%
        User user= (User) session.getAttribute("session_user");
        out.print("<tr> <td>"+user.getUsername()+"</td> <td>"+user.getPassword()+"</td><td>"+user.getAge()+"</td></tr>");
      %>
        <%--<form action="${pageContext.request.contextPath}/userServlet?op=modi" method="post">--%>
        <%--<tr> <td><input type="text" name="my_username"></td> <td><input type="text" name="my_password"></td><td><input type="text" name="my_age"></td></tr>--%>
          <tr><td>
            <button class="btn btn-default" onclick= window.location.href='${pageContext.request.contextPath}/modify.jsp'>修改</button>
          </td><td>
            <button class="btn btn-default" onclick= window.location.href="${pageContext.request.contextPath}/userServlet?op=logout">注销</button>
          </td></tr>
        <%--</form>--%>
      </table>




    </c:when>
    <c:otherwise>

      <button class="btn btn-default" onclick= window.location.href="${pageContext.request.contextPath}/login.jsp">登录</button>
      <button class="btn btn-default" onclick= window.location.href="${pageContext.request.contextPath}/register.jsp">注册</button>
    </c:otherwise>
  </c:choose>




  </body>
</html>
