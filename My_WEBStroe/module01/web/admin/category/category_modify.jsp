<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/5
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function checkModify() {
        var cname = document.getElementsByName("cname")[0].value;
        if (cname === "") {
            alert("您还没有修改");
            return false;
        }
        if (cname === "") {
            alert("您还没有输入");
            return false;
        }
    }

    function isCategoryNameAvailable() {
        var cname = document.getElementsByName("cname")[0];
        var message = document.getElementById("message");
        if (cname.value === "") {
            message.innerText = "";
            return;
        }
        var request = new XMLHttpRequest();
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var responseText = request.responseText;
                if (responseText === "true") {
                    message.innerText = "分类名可用";
                    message.style.color = 'blue';
                } else {
                    message.innerText = "该分类已存在";
                    message.style.color = 'red';
                }
            }
        };
        var url = "/bookstore/admin/AjaxServlet?ajax=isCategoryNameAvailable&cname=" + cname.value;
        request.open("GET",url, true);
        request.send(null);
    }
</script>

<style type="text/css">
    <!--
    body {
        margin-left: 3px;
        margin-top: 0px;
        margin-right: 3px;
        margin-bottom: 0px;
    }

    .STYLE1 {
        color: #e1e2e3;
        font-size: 12px;
    }

    .STYLE6 {
        color: #000000;
        font-size: 12px;
    }

    .STYLE10 {
        color: #000000;
        font-size: 12px;
    }

    .STYLE19 {
        color: #344b50;
        font-size: 12px;
    }

    .STYLE21 {
        font-size: 12px;
        color: #3b6375;
    }

    .STYLE22 {
        font-size: 12px;
        color: #295568;
    }
    .input01{
        text-align: center;
    }
    -->
</style>

<body>
<%
    CategoryService service=new CategoryService();
    List<Category> categories= service.categoryList();
    String mo=request.getParameter("mo");
    int n= Integer.valueOf(mo);
    request.setAttribute("this_cid",categories.get(n).getCid());
    request.setAttribute("this_cname",categories.get(n).getCname());
        /*out.print("<tr>");
        out.print("<td>"+categories.get(n).getCid()+"</td>"+"<td>"+categories.get(n).getCname()+"</td>"+"<td><a href='/Category?op=delete&de="+i+"'>删除</a>/<a href='/category_modify.jsp?mo="+i+"'></td>");
        out.println("</tr>");*/
%>
<%--<form action="/Category?op=modify&pre_cname=${this_cname}" method="post">--%>
<%--<table>--%>
    <%--<tr> <td>分类id</td> <td>分类名</td><td>修改分类</td></tr>--%>

    <%--<tr>--%>
        <%--<td><input type="text" name="cid" value="${this_cid}" readonly="true"/> </td>--%>
        <%--<td><input type="text" name="cname"   value="${this_cname}"/> </td>--%>
        <%--<td><input type="submit"  value="修改分类名" /></td>--%>
    <%--</tr>--%>
<%--</table>--%>
<%--</form>--%>

<form method="post" action="/Category?op=modify&pre_cname=${this_cname}" onsubmit="return checkModify()">
    <table width="100%" border="0" align="center" cellpadding="0"
           cellspacing="0">
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="24" bgcolor="#353c44">
                            <table width="100%"
                                   border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td>
                                        <table width="100%" border="0" cellspacing="0"
                                               cellpadding="0">
                                            <tr>
                                                <td width="6%" height="19" valign="bottom">
                                                    <div
                                                            align="center">
                                                        <img src="images/tb.gif" width="14" height="14"/>
                                                    </div>
                                                </td>
                                                <td width="94%" valign="bottom"><span class="STYLE1">
														修改分类</span>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <div align="right">
											<span class="STYLE1">
												<!-- <input type="button" value="添加"/> -->
                                                <!-- <input type="submit" value="删除" /> -->
												&nbsp;&nbsp;
											</span>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <table width="100%" border="0" cellpadding="0"
                   cellspacing="1" bgcolor="#a8c7ce">
                <tr><td><div align="center">分类id</div></td> <td><div align="center">分类名</div></td><td><div align="center">修改分类</div></td></tr>
                <tr>
            <td width="20%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center"><input class="input01" type="text" name="cid" value="${this_cid}" readonly="true"/> </div> </td>
            <td width="50%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><input class="input01" type="text" name="cname"   value="${this_cname}"/></div> </td>
            <td width="30%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><input type="submit"  value="修改分类名" /></div></td>
                </tr>
            </table>
        </tr>
        <%--<tr>--%>
            <%--<td>--%>

                <%--<table width="100%" border="0" cellpadding="0"--%>
                       <%--cellspacing="1" bgcolor="#a8c7ce">--%>
                    <%--<tr>--%>
                        <%--<td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">--%>
                            <%--<div--%>
                                    <%--align="center">--%>
                                <%--<input type="checkbox" name="checkbox" id="checkbox11"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">--%>
                            <%--<div--%>
                                    <%--align="center">--%>
                                <%--<span class="STYLE10"><span>分类类名：</span></span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">--%>

                            <%--<div--%>
                                    <%--align="left">--%>
                                <%--<span style="color:red">*</span>--%>

                                <%--<input type="text" name="cname" value="经管" onblur="isCategoryNameAvailable()"/>--%>
                                <%--<span id="message" class="STYLE6"></span>--%>
                            <%--</div>--%>
                        <%--</td>--%>

                    <%--</tr>--%>

                <%--</table>--%>
            <%--</td>--%>
        <%--</tr>--%>

        <%--<tr>--%>
            <%--<td height="30">--%>
                <%--<table width="100%" border="0" cellspacing="0" cellpadding="0">--%>
                    <%--<tr>--%>
                        <%--<td width="33%">--%>
                            <%--<div align="left"></div>--%>
                        <%--</td>--%>
                        <%--<td width="67%">--%>
                            <%--<div align="right">--%>
                                <%--<input type="button" onclick="history.go(-1);" value="返回"/>--%>
                                <%--<input type="submit" value="修改"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
            <%--</td>--%>
        <%--</tr>--%>
    </table>
</form>


</body>
</html>
