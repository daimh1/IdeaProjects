<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="homework02.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/1
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
<tr><td><h1>用户列表</h1></td></tr>

<%
   List<User> users=null;
   List<String> ages=new ArrayList<>();
   List<String> usernames=new ArrayList<>();
   List<String> passwords=new ArrayList<>();
    users= (List<User>) request.getAttribute("users");
    for(int i=0;i<users.size();i++){
        usernames.add(users.get(i).getUsername());
        ages.add(users.get(i).getAge());
        passwords.add(users.get(i).getPassword());
    }
    request.setAttribute("usernames",usernames);
    request.setAttribute("passwords",passwords);
    request.setAttribute("ages",ages);
    //out.print(users);

%>
    <tr>
    <c:forEach var="username" items="${usernames}">

        <td>${username}</td>

    </c:forEach>
    </tr>
    <tr>
    <c:forEach var="password" items="${passwords}">

        <td>${password}</td>

    </c:forEach>
    </tr>
    <tr>
    <c:forEach var="age" items="${ages}">

        <td>${age}</td>

    </c:forEach>
    </tr>

</table>

</body>
</html>
