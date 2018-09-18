<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.webstore.utils.PageHelper" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/5
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类列表</title>
    <style type="text/css">
        .STYLE1 {
            color: #e1e2e3;
            font-size: 12px;
        }

    </style>
</head>
<body>
<%
    String num = request.getParameter("num");
    if (num==null||num.isEmpty()){

        num="1";
    }

    CategoryService categoryService=new CategoryService();
    PageHelper<Category> pageHelper= null;
    try {
        pageHelper = categoryService.findCategoryListByPagenumber(num);
        request.setAttribute("page",pageHelper);

    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<%--<table>--%>
    <%--<tr></tr><td><h1>分类列表</h1></td></tr>--%>
    <%--<tr> <td>分类id</td> <td>分类名</td><td>修改分类</td></tr>--%>
<%--<%--%>
    <%--CategoryService service=new CategoryService();--%>
    <%--List<Category> categories= service.categoryList();--%>
    <%--String thispath=request.getContextPath();--%>
    <%--System.out.println(thispath);--%>

    <%--for(int i=0;i<categories.size();i++){--%>
        <%--out.print("<tr>");--%>
        <%--out.print("<td>"+categories.get(i).getCid()+"</td>"+"<td>"+categories.get(i).getCname()+"</td>"+"<td><a href='/Category?op=delete&de="+i+"'>删除</a>/<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/category/category_modify.jsp?mo="+i+"'>修改</a></td>");--%>
        <%--out.println("</tr>");--%>

    <%--}--%>
<%--%>--%>
<%--</table>--%>
<form action="/bookstore/admin/CategoryServlet" method="post"
      onsubmit="return checkSubmit()"
      onkeypress="if(13 === event.keyCode){jump();return false;}">
    <input type="hidden" name="op" value="deleteMulti"/>
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
                                                        <img src="#" width="14" height="14"/>
                                                    </div>
                                                </td>
                                                <td width="94%" valign="bottom"><span class="STYLE1">
														分类列表</span>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <div align="right">
											<span class="STYLE1">
												<!-- <input type="button" value="添加"/> -->
												<input type="submit" value="删除"/>
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
                                <input type="checkbox" name="checkbox" id="checkbox11" onclick="checkAll()"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">id</span>
                            </div>
                        </td>
                        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">分类名</span>
                            </div>
                        </td>
                        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">基本操作</span>
                            </div>
                        </td>
                    </tr>

                    <%
                        //CategoryService service=new CategoryService();
                        List<Category> categories= pageHelper.getRecords();
                        String thispath=request.getContextPath();
                        System.out.println(thispath);

                        for(int i=0;i<categories.size();i++){
                            out.print("<tr>");
                            out.print("<td width=\"4%\" height=\"20\" bgcolor=\"#FFFFFF\" class=\"STYLE10\">\n" +
                                    "                            <div align=\"center\">\n" +
                                    "                                <input type=\"checkbox\" name=\"cid\" value=\""+i+"\"\n" +
                                    "                                       onclick=\"checking()\"/>\n" +
                                    "                            </div>\n" +
                                    "                        </td>");
                            out.print("<td width=\"10%\" height=\"20\" bgcolor=\"#FFFFFF\" class=\"STYLE6\">\n" +
                                    "                                <div align=\"center\">\n" +
                                    "                                    <span class=\"STYLE10\">"+categories.get(i).getCid()+"</span>\n" +
                                    "                                </div>\n" +
                                    "                            </td>\n"+"<td width=\"15%\" height=\"20\" bgcolor=\"#FFFFFF\" class=\"STYLE6\">\n" +
                                    "                                <div align=\"center\">\n" +
                                    "                                    <span class=\"STYLE10\">"+categories.get(i).getCname()+"</span>\n" +
                                    "                                </div>\n" +
                                    "                            </td>\n"+"<td width=\"14%\" height=\"20\" bgcolor=\"#FFFFFF\" class=\"STYLE6\">\n" +
                                    "                                <div align=\"center\">\n" +
                                    "                                    <div align=\"center\" class=\"STYLE21\">\n<a href='/Category?op=delete&de="+categories.get(i).getCid()+"'>删除</a>/<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/category/category_modify.jsp?mo="+categories.get(i).getCid()+"'>修改</a></div>\n" +
                                    "                                </div>\n" +
                                    "                            </td>\n");
                            out.println("</tr>");

                        }
                    %>
                    <%--<tr>--%>
                        <%--<td width="4%" height="20" bgcolor="#FFFFFF" class="STYLE10">--%>
                            <%--<div align="center">--%>
                                <%--<input type="checkbox" name="cid" value="4"--%>
                                       <%--onclick="checking()"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<span class="STYLE10">4</span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="15%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<span class="STYLE10">生活</span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="14%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<div align="center" class="STYLE21">--%>
                                    <%--<a href="/bookstore/admin/category/updateCategory.jsp?cid=4&cname=生活">编辑</a>--%>
                                    <%--|--%>
                                    <%--<a href="javascript:checkDelete(4)">删除</a>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

                    <%--<tr>--%>
                        <%--<td width="4%" height="20" bgcolor="#FFFFFF" class="STYLE10">--%>
                            <%--<div align="center">--%>
                                <%--<input type="checkbox" name="cid" value="5"--%>
                                       <%--onclick="checking()"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<span class="STYLE10">5</span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="15%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<span class="STYLE10">经管</span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="14%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<div align="center" class="STYLE21">--%>
                                    <%--<a href="/bookstore/admin/category/updateCategory.jsp?cid=5&cname=经管">编辑</a>--%>
                                    <%--|--%>
                                    <%--<a href="javascript:checkDelete(5)">删除</a>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

                    <%--<tr>--%>
                        <%--<td width="4%" height="20" bgcolor="#FFFFFF" class="STYLE10">--%>
                            <%--<div align="center">--%>
                                <%--<input type="checkbox" name="cid" value="6"--%>
                                       <%--onclick="checking()"/>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="10%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<span class="STYLE10">6</span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="15%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<span class="STYLE10">科技</span>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                        <%--<td width="14%" height="20" bgcolor="#FFFFFF" class="STYLE6">--%>
                            <%--<div align="center">--%>
                                <%--<div align="center" class="STYLE21">--%>
                                    <%--<a href="/bookstore/admin/category/updateCategory.jsp?cid=6&cname=科技">编辑</a>--%>
                                    <%--|--%>
                                    <%--<a href="javascript:checkDelete(6)">删除</a>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</td>--%>
                    <%--</tr>--%>

                </table>
            </td>
        </tr>
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="33%"><div align="left">
								<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
                                    ${page.totalRecordsNum }</strong> 条记录，当前第<strong>${page.currentPageNum }</strong> 页，共 <strong>${page.totalPageNum }</strong> 页</span>
                        </div>
                        </td>
                        <td width="67%">
                            <table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="49">
                                        <div align="center">
											<span class="STYLE22">
											<a href="${pageContext.request.contextPath }/admin/category/category.jsp?num=1">首页</a>
											</span>
                                        </div>
                                    </td>
                                    <td width="49">
                                        <div align="center">
											<span class="STYLE22">
											<a href="${pageContext.request.contextPath }/admin/category/category.jsp?num=${page.prevPageNum}">上一页</a>
											</span>
                                        </div>
                                    </td>
                                    <td width="49"><span class="STYLE22">
									    <div align="center">
											<span class="STYLE22">
											<a href="${pageContext.request.contextPath }/admin/category/category.jsp?num=${page.nextPageNum}">下一页</a>
											</span>
										</div>
                                    </span></td>
                                    <td width="49">
                                        <div align="center">
                                            <span class="STYLE22"><a href="${pageContext.request.contextPath }/admin/category/category.jsp?num=${page.totalPageNum }">尾页</a></span>
                                        </div>
                                    </td>
                                    <td width="37" class="STYLE22"><div align="center">转到</div>
                                    </td>
                                    <td width="22">
                                        <div align="center">
                                            <input type="text" name="num" id="num" value="${page.currentPageNum }" style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;" />
                                        </div>
                                    </td>
                                    <td width="22" class="STYLE22"><div align="center">页</div>
                                    </td>
                                    <td width="35">
                                        <div align="center">
                                            <span class="STYLE22"><a style="cursor:pointer;" onclick="jump()">跳转</a></span>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

    </table>
</form>
<script type="text/javascript">

    function jump() {

        var num = document.getElementById("num").value;
        if (!/^[1-9][0-9]*$/.test(num)) {
            alert("请输入正确的页码");
            return;
        }

        if (num > 2) {
            alert("页码超出范围");
            return;
        }

        window.location.href = "/admin/category/category.jsp?num=" + num;

    }
</script>

</body>
</html>
