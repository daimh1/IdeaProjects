<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    //page域
    pageContext.setAttribute("name","深圳");

    request.setAttribute("name","广东");

    session.setAttribute("name","华南");

    application.setAttribute("name","中国");



    //取数据 ，可以在指定域空间里去取对应的数据

    Object name = pageContext.getAttribute("name");//深圳

    out.println("name="+name);

    Object name1 = pageContext.getAttribute("name", 2);//app4 session3 request2 page1
    out.println("name1="+name1);


    //

    Object name2 = pageContext.findAttribute("name");
    out.println("name2="+name2);


%>
</body>
</html>
