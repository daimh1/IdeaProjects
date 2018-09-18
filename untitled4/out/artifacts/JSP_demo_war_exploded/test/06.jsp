<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

 <%

     //操作域 有三个方法
     pageContext.setAttribute("name","aaaa");

     Object name = pageContext.getAttribute("name");


     /*pageContext.removeAttribute("name");

     name = pageContext.getAttribute("name");

     out.println("after="+name);*/

     ServletRequest request1 = pageContext.getRequest();

     ServletResponse response1 = pageContext.getResponse();

     ServletConfig servletConfig = pageContext.getServletConfig();

     ServletContext application1 = pageContext.getServletContext();

     HttpSession session1 = pageContext.getSession();

     Object page1 = pageContext.getPage();  //page

     JspWriter out1 = pageContext.getOut();

     Exception exception2 = pageContext.getException();

 %>

 <%
     out.println("before="+name);

 %>

<%!

  private  String username ="aaa";



%>

</body>
</html>
