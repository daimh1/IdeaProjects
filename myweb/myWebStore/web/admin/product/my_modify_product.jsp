<%@ page import="com.webstore.bean.Product" %>
<%@ page import="com.webstore.service.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.CategoryService" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/6
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProductService service=new ProductService();
    //List<Product> objs= service.productList();
    String mo=request.getParameter("mo");
    //int n= Integer.valueOf(mo);
    Product obj=service.findProductByPId(mo).get(0);
    request.setAttribute("this_pid",obj.getPid());
    request.setAttribute("this_pname",obj.getPname());
    request.setAttribute("this_estoreprice",obj.getEstoreprice());
    request.setAttribute("this_markprice",obj.getMarkprice());
    request.setAttribute("this_pnum",obj.getPnum());
    request.setAttribute("this_cname",(new CategoryService()).getCategoryByCid(obj.getCid()).getCname());
    request.setAttribute("this_descibe",obj.getdescibe());
        /*out.print("<tr>");
        out.print("<td>"+categories.get(n).getCid()+"</td>"+"<td>"+categories.get(n).getCname()+"</td>"+"<td><a href='/Category?op=delete&de="+i+"'>删除</a>/<a href='/category_modify.jsp?mo="+i+"'></td>");
        out.println("</tr>");*/
%>
<form action="/Product?op=modify" method="post">
    <table>
        <tr> <td>商品号</td> <td>商品名称</td><td>商城价</td><td>市场价</td><td>库存</td><td>所属分类</td><td>基本操作</td></tr>

        <tr>
            <td><input type="text" name="pid" value="${this_pid}" readonly="true"/> </td>
            <td><input type="text" name="pname"   value="${this_pname}"/> </td>
            <td><input type="text" name="estoreprice"   value="${this_estoreprice}"/> </td>
            <td><input type="text" name="markprice"   value="${this_markprice}"/> </td>
            <td><input type="text" name="pnum"   value="${this_pnum}"/> </td>
            <td><input type="text" name="cname"   value="${this_cname}"/> </td>
            <td><input type="text" name="descibe"   value="${this_descibe}"/> </td>

            <td><input type="submit"  value="修改" /></td>
        </tr>
    </table>
</form>
</body>
</html>
