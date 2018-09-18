<%@ page import="java.util.List" %>
<%@ page import="com.webstore.bean.Product" %>
<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.service.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/6
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr> <td>商品号</td> <td>商品名称</td><td>商城价</td><td>市场价</td><td>库存</td><td>所属分类</td><td>基本操作</td></tr>
    <%
        List<Product> products= null;
        products=(List<Product>) request.getAttribute("productlist");
        if(products==null) products=(new ProductService().productList());



        /*ProductService service=new ProductService();
        List<Product> products= service.productList();*/
        try {
            for(int i=0;i<products.size();i++){
                out.print("<tr>");
                out.print("<td>"+products.get(i).getPid()+"</td>"+"<td>"+products.get(i).getPname()+"</td>"+"<td>"+products.get(i).getEstoreprice()+"</td>"+"<td>"+products.get(i).getMarkprice()+"</td>"+"<td>"+products.get(i).getPnum()+"</td>"+"<td>"+(new CategoryService()).getCategoryByCid(products.get(i).getCid()).getCname()+"</td>"+"<td><a href='/Product?op=delete&de="+products.get(i).getPid()+"'>删除</a>/<a href='"+request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/admin/product/modify_product.jsp?mo="+products.get(i).getPid()+"'>修改</a></td>");
                out.println("</tr>");

            }
        }catch (NullPointerException e){

        }

    %>
</table>

</body>
</html>
