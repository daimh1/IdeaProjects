<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/20
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/work03.do" method="post">
        用户<input type="text" name="username" /><br>
        密码<input type="password" name="password" /><br>
        年龄<input type="text" name="age" value="18" /><br>
        生日  <input type="text" name="birthday"   /><br>

        老师姓名<input type="text" name="teacher.tname" /><br>
        鞋子品牌<input type="text" name="brand"><br>
        <input type="submit"/>
    </form>
</body>
</html>
