<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/3
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>

<h2>请修改您的数据：</h2>

<form action="${pageContext.request.contextPath}/userServlet?op=modi" method="post">
    <table  class="table table-bordered table-striped">
        <tr>
            <td>*用户名：</td><td>*密码:</td><td>*Age:</td>
        </tr>
        <tr>
            <td><input type="text" name="my_username" value="${session_username}" readonly="true"/> </td>


            <td><input type="text" name="my_password"   value="${session_password}"/> </td>

            <td><input type="text" name="my_age"   value="${session_age}"/> </td>
        </tr>
        <tr>
            <td><input type="submit"  value="修改注册信息" /></td>
        </tr>

    </table>
</form>

</body>
</html>
