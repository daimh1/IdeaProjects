<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/5
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin_center</title>

</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <%--<td width="8" bgcolor="#353c44">&nbsp;</td>--%>
        <td width="150" valign="top">
            <iframe height="100%" width="100%" border="0" frameborder="0" src="left.jsp" name="leftFrame" id="leftFrame" title="leftFrame"></iframe>
        </td>
        <%--<td width="10" bgcolor="#add2da">&nbsp;</td>--%>
        <td valign="top">
            <iframe height="100%" width="100%" border="0" frameborder="0" src="welcome.jsp" name="rightFrame" id="rightFrame" title="rightFrame"  ></iframe>
        </td>
        <%--<td width="8" bgcolor="#353c44">&nbsp;</td>--%>
    </tr>
</table>


</body>
</html>
