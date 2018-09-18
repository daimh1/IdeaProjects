<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/7
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商城后台登录</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" src="js/js.js"></script>
</head>
<body>
<div id="top"> </div>
<form id="login" name="login" action="/adminlogin" method="post">
    <input type="hidden" name="op" value="login"/>
    <div id="center">
        <div id="center_left"></div>
        <div id="center_middle">
            <div style="height: 10px"></div>
            <div class="user">
                <label>用户名
                    <input type="text" name="username" id="username" />
                </label>
            </div>
            <div style="height: 6px"></div>
            <div class="user">
                <label>密码
                    <input type="password" name="password" id="password" />
                </label>
            </div>
        </div>
        <div id="center_middle_right"></div>
        <div id="center_submit">
            <div class="button"> <img src="images/dl.gif" width="57" height="20" onclick="form_submit()" > </div>
            <div class="button"> <img src="images/cz.gif" width="57" height="20" onclick="form_reset()"> </div>
        </div>
        <div id="center_right"></div>
    </div>
</form>
<div id="footer"></div>
</body>
</html>
