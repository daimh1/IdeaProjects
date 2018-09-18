<%@ page import="java.io.IOException" %>
<%@ page import="Utils.DBCPUtils" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="org.apache.commons.dbutils.QueryRunner" %>
<%@ page import="org.apache.commons.dbutils.handlers.MapListHandler" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<table class="table table-bordered table-striped">
    <tr></tr><td><h1>用户列表</h1></td></tr>
    <tr> <td>username</td> <td>password</td><td>age</td><td>function</td></tr>



<%

    try {


    if(session.getAttribute("username").equals("admin")&&session.getAttribute("password").equals("1234")) {
        
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            List<Map<String, Object>> query = queryRunner.query("select * from user", new MapListHandler());
            for (Map<String, Object> q : query) {
                out.println("<tr>");

                //为了保证用户名-密码-年龄顺序一致，遍历三次map，每次取出一个元素
                for (Map.Entry<String, Object> entry : q.entrySet()) {
                    if (entry.getKey().equals("username")) {
                        out.println("<td>" + entry.getValue().toString() + "</td>");
                    }
                }
                for (Map.Entry<String, Object> entry : q.entrySet()) {
                    if (entry.getKey().equals("password"))
                        out.println("<td>" + entry.getValue().toString() + "</td>");
                }
                for (Map.Entry<String, Object> entry : q.entrySet()) {
                    if (entry.getKey().equals("age"))
                        out.println("<td>" + entry.getValue().toString() + "</td>");
                }
                out.println("<td>" + "<a href=\"delete\">删除</a>" + "</td>");
                out.println("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //不管是空指针还是session错误，都不能进入admin页面
    }else {
        out.println("登录失败");
    }}catch (Exception e){
    out.println("登录失败");
}
%>
    <tr> <td><input type="text" name="username"></td> <td><input type="text" name="password"></td><td><input type="text" name="age"></td><td><a href="/admin">提交</a></td></tr>
</table>
<a href="delete.jsp">注销</a>
</body>
</html>
