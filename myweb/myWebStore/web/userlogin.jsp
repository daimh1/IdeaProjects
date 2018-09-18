<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/8
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="user/css/style.css">
</head>
<body>
<%--<form action="/userLogin" method="post">--%>
    <%--<table border="1">--%>
        <%--<tr><td>用户名</td><td><input type="text" name="username"></td></tr>--%>
        <%--<tr><td>密码</td><td><input type="password" name="password"></td></tr>--%>
    <%--</table>--%>
    <%--<input type="submit" value="登录">--%>
<%--</form>--%>
<section class="container">
    <div class="login">
        <h1>用户登录 <span style="text-align:center;padding-top:2px;"><font color="#ff0000">${requestScope["msg"]}</font>
														</span></h1>
        <form method="post" action="${pageContext.request.contextPath }/userLogin">

            <input type="hidden" name="op" value="login"/>
            <p><input type="text" name="username" value="" placeholder="用户名"></p>
            <p><input type="password" name="password" value="" placeholder="密码"></p>

            <p><input type="text" name="verifyCode" placeholder="VerifyCode" style="width: 150px;">
                <img src="/verify" alt="verifyCode" width="120px" height="30px" style="vertical-align: middle;"></p>


            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    记住密码
                </label>
            </p>
            <p class="submit"><input type="submit" name="commit" value="登录"></p>
        </form>
    </div>
</section>
</body>
</html>
