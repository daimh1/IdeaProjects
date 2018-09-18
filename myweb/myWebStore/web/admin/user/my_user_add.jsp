<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/8
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/User?op=add" method="post">
<table>
    <tr>
        <td>用户名</td><td><input type="text" name="username"></td>
        <td>昵称</td><td><input type="text" name="nickname"></td>
        <td>邮箱</td><td><input type="text" name="email"></td>
        <td>密码</td><td><input type="password" name="password"></td>
        <td>出生日期</td><td><input type="text" name="birthday"></td>
    </tr>

</table>
    <input type="submit" value="添加用户">
</form>
</body>
</html>
