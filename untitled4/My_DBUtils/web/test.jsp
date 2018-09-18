<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        public void printalert(JspWriter out) throws IOException {
            out.println("<script language=javascript>");
            out.println("alert('错误'");
            out.println("</script>");
        }
    %>
<%
    printalert(out);
%>

</body>
</html>
