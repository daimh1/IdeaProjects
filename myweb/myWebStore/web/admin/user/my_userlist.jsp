<%@ page import="com.webstore.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.UserService" %><%--
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
<table>
    <tr>
        <td></td><td>id</td><td>系统用户名</td><td>昵称</td><td>邮箱</td><td>密码</td><td>出生日期</td><td>注册时间</td><td>基本操作</td>
    </tr>
    <%
        List<User> users=null;
        UserService service=new UserService();
        users=service.userList();

        for(int i=0;i<users.size();i++){
            out.print("<tr>");
            out.print("<td></td><td>"+users.get(i).getUid()+"</td><td>"+users.get(i).getUsername()+"</td><td>"+users.get(i).getNickname()+"</td><td>"+users.get(i).getEmail()+"</td><td>"+users.get(i).getPassword()+"</td><td>"+users.get(i).getBirthday()+"</td><td>"+users.get(i).getRegisterdate()+"</td><td>"+"<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/user/user_modify.jsp?mo="+users.get(i).getUid()+"'>修改</a></td>");
            out.println("</tr>");
        }

    %>

</table>

</body>
</html>
