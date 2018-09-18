<%@ page import="java.util.List" %>
<%@ page import="com.webstore.bean.Admin" %>
<%@ page import="com.webstore.service.AdminService" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/7
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td></td><td>id</td><td>系统用户名</td><td>密码</td><td>基本操作</td>
    </tr>
    <%
        List<Admin> admins=null;
        AdminService service=new AdminService();
        admins=service.findAllAdmin();

        for(int i=0;i<admins.size();i++){
            out.print("<tr>");
            out.print("<td></td><td>"+admins.get(i).getAdmin_id()+"</td><td>"+admins.get(i).getAdmin_name()+"</td><td>"+admins.get(i).getAdmin_password()+"</td><td>"+"<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/admin_account/admin_modify.jsp?mo="+admins.get(i).getAdmin_id()+"'>修改</a></td>");
            out.println("</tr>");
        }

    %>

</table>

</body>
</html>
