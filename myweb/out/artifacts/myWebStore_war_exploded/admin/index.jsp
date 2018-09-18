<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/4
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商城后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>--%>
</head>
<%--<nav class="navbar navbar-default navbar-fixed-top" >--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="/admin/welcome.jsp" target="rightFrame">--%>
                <%--&lt;%&ndash;放入网页图标&ndash;%&gt;--%>
                <%--<img src="/images/2co.gif" height="21" width="57">--%>

            <%--</a>--%>
            <%--<p class="navbar-text navbar-right"><a href="/admin/welcome.jsp" target="rightFrame" class="navbar-link">首页</a></p>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</nav>--%>
<%--<br>--%>
<%--<br>--%>
<%--<br>--%>
<%--<div class="embed-responsive embed-responsive-16by9">--%>
    <%--<iframe class="embed-responsive-item" src="center.jsp"></iframe>--%>
<%--</div>--%>
<%--<frameset rows="*" frameborder="no" border="0" framespacing="0">--%>
    <%--&lt;%&ndash;<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />&ndash;%&gt;--%>
    <%--<frame src="center.jsp" name="mainFrame" id="mainFrame" style=""/>--%>
    <%--&lt;%&ndash;<frame src="down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />&ndash;%&gt;--%>
<%--</frameset>--%>
<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
    <frame src="top.jsp"    name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
    <frame src="center.jsp" name="mainFrame" id="mainFrame" style=""/>
    <frame src="down.jsp"   name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
<body>




</body>
</html>
