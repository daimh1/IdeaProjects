<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/7
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>添加管理员</h2>
<form action="/Admin?op=add" method="post">
    <table>
        <tr><td>管理员用户名：</td><td><input type="text" name="admin_name"></td></tr>
        <tr><td>密码：</td><td><input type="password" name="admin_password"></td></tr>
        <tr><td>确认密码：</td><td><input type="password" name="admin_password2"></td></tr>
    </table>

    <input type="submit" value="添加">
</form>

</body>
</html>
