<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/6
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>搜索商品</h2>
<form action="/Product?op=search" method="post">
<table>
    <tr><td>商品编号：</td><td><input type="text" name="search_pid"></td></tr>
    <tr><td>种类：</td><td>
        <select name="search_cid">
            <option value=""></option>
            <%
                CategoryService categoryService=new CategoryService();
                List<Category> categories=categoryService.categoryList();
                for(int i=0;i<categories.size();i++){
                    out.print("<option value=\""+categories.get(i).getCid()+"\">"+categories.get(i).getCname()+"</option>");
                }

            %>
    </select>
    </td></tr>
    <tr><td>商品名称：</td><td><input type="text" name="search_pname"></td></tr>
    <tr><td>价格区间：</td><td><input type="text" name="search_price1">-<input type="text" name="search_price2"></td></tr>
</table>
    <input type="submit" value="搜索">
</form>
</body>
</html>
