<%@ page import="com.webstore.bean.Admin" %>
<%@ page import="com.webstore.service.AdminService" %><%--
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
<%
    AdminService service=new AdminService();
    String mo=request.getParameter("mo");
    Admin admin=service.findAdminById(mo);

    request.setAttribute("this_aid",admin.getAdmin_id());
    request.setAttribute("this_aname",admin.getAdmin_name());
    request.setAttribute("this_apassword",admin.getAdmin_password());
%>
<form action="/Admin?op=modify" method="post">
    <table>
        <tr><td>管理员id</td><td><input type="text" name="admin_id" value="${this_aid}" readonly="true"/></td></tr>
        <tr><td>管理员账号</td><td><input type="text" name="admin_name" value="${this_aname}"/></td></tr>
        <tr><td>密码</td><td><input type="password" name="admin_password" /></td></tr>
        <tr><td>确认密码</td><td><input type="password" name="admin_password2" /></td></tr>
    </table>
    <td><input type="submit"  value="修改" /></td>
</form>
</body>
</html>
