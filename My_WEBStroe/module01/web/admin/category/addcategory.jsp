<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/5
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类</title>
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

        -->
    </style>

</head>
<body>
<%--<form action="/Category?op=add" method="post">--%>
<%--<table>--%>
    <%--<tr></tr><td><h1>添加分类</h1></td></tr>--%>
    <%--<tr>  <td>分类名</td><td>添加</td></tr>--%>
    <%--<tr>--%>
    <%--<td><input type="text" name="cname"/> </td>--%>
    <%--<td><input type="submit"  value="添加分类" /></td>--%>
    <%--</tr>--%>
<%--</table>--%>
<%--</form>--%>
<form method="post" action="/Category?op=add">
    <input type="hidden" name="op" value="addCategory"/>

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
                                                </td>
                                                <td width="94%" valign="bottom"><span class="STYLE1">
														增加分类</span>
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
            <td>

                <table width="100%" border="0" cellpadding="0"
                       cellspacing="1" bgcolor="#a8c7ce">
                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10"><span>分类类名：</span></span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">

                            <div
                                    align="left">
                                <span style="color:red">*</span>

                                <input type="text" name="cname" onblur="isCategoryNameAvailable()"/>
                                <span id="message" class="STYLE6"></span>

                            </div>
                        </td>

                    </tr>

                </table>
            </td>
        </tr>

        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="33%">
                            <div align="left"></div>
                        </td>
                        <td width="67%">
                            <div align="right">
                                <input type="submit" value="增加"/>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
