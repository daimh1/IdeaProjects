<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    int count=0;
    Map<String,String> acco=new HashMap<>();
%>
<%!
    public String getRemortIP(HttpServletRequest request) {

        if (request.getHeader("x-forwarded-for") == null) {

            return request.getRemoteAddr();

        }

        return request.getHeader("x-forwarded-for");

    }
%>
<%
    if(acco.containsKey(getRemortIP(request))){
        out.print("当前访问总人数："+count);
        out.print("<br>访问ip："+getRemortIP(request));
    }else{
        acco.put(getRemortIP(request),getRemortIP(request));
        count++;
        out.print("当前访问总人数："+count);
        out.print("访问ip："+getRemortIP(request));
    }
%>
</body>
</html>
