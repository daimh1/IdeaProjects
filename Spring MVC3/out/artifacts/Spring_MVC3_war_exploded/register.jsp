<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/register.do" method="post" enctype="multipart/form-data">
    用户<input type="text" name="username" /><br>
    密码<input type="password" name="password" /><br>
    照片1<input type="file" name="photo"><br>
    照片2<input type="file" name="photo"><br>
        <input type="submit">
</form>
</body>
</html>
