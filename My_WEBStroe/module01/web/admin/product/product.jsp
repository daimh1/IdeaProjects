<%@ page import="com.webstore.service.ProductService" %>
<%@ page import="com.webstore.bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.CategoryService" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/6
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>商品列表</h2>
<table>
    <tr> <td>商品号</td> <td>商品名称</td><td>商城价</td><td>市场价</td><td>库存</td><td>所属分类</td><td>基本操作</td></tr>
    <%
        ProductService service=new ProductService();
        List<Product> products= service.productList();
        for(int i=0;i<products.size();i++){
            out.print("<tr>");
            out.print("<td>"+products.get(i).getPid()+"</td>"+"<td>"+products.get(i).getPname()+"</td>"+"<td>"+products.get(i).getEstoreprice()+"</td>"+"<td>"+products.get(i).getMarkprice()+"</td>"+"<td>"+products.get(i).getPnum()+"</td>"+"<td>"+(new CategoryService()).getCategoryByCid(products.get(i).getCid()).getCname()+"</td>"+"<td><a href='/Product?op=delete&de="+i+"'>删除</a>/<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/product/modify_product.jsp?mo="+i+"'>修改</a></td>");
            out.println("</tr>");

        }
    %>
</table>

</body>
</html>
