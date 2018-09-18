<%@ page import="java.io.File" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%

    Date date ;


    File file = new File("");

    String aaa = request.getParameter("aaa");


    int x =1;
    int y=2;
    int z=x+y;

    out.print("答案x+y="+z);

  %>


  王道论坛
  <hr>
  <form action="" method="">
    <input type="text" value=""><br>
    <input type="submit">
  </form>


  <%!
    private  String username ;
  %>

  </body>
</html>
