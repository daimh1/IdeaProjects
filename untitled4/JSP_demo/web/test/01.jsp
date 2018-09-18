<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
王道论坛 <%=getUsername()%>
<%--<%= 1.22f %>--%>

<%--<%=   new Date()  %>--%>

<%--<%=  "hello,word!" %>--%>
<%!
    private  String username ="wangdao" ;

    public String getUsername(){

        return  username;
    }

    public static void test(){


    }
%>

</body>
</html>
