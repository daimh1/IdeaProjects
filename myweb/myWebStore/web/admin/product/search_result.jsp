<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/jquery.js"></script>
    <title>无标题文档</title>
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
<%
    List<Product> products= null;
    products=(List<Product>) request.getAttribute("productlist");
    request.setAttribute("products1",products);
%>
<form action="${pageContext.request.contextPath }/admin/product/productlist.jsp" method="post">
    <input type="hidden" name="op" value="deleteMulti"/>
    <table width="100%" border="0" align="center" cellpadding="0"
           cellspacing="0">
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="24" bgcolor="#353c44"><table width="100%"
                                                                 border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td><table width="100%" border="0" cellspacing="0"
                                           cellpadding="0">
                                    <tr>
                                        <td width="6%" height="19" valign="bottom"><div
                                                align="center">
                                            <img src="#" width="14" height="14" />
                                        </div>
                                        </td>
                                        <td width="94%" valign="bottom"><span class="STYLE1">
														商品列表</span>
                                        </td>
                                    </tr>
                                </table>
                                </td>
                                <td><div align="right">
											<span class="STYLE1">
												<!-- <input type="button" value="添加"/> -->
												<input type="submit" value="  " />
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
            <td><table width="100%" border="0" cellpadding="0"
                       cellspacing="1" bgcolor="#a8c7ce">
                <tr>
                    <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div
                            align="center">
                        <input type="checkbox" name="checkbox" id="checkbox11" />
                    </div>
                    </td>
                    <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">商品号</span>
                    </div>
                    </td>
                    <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">商品名称</span>
                    </div>
                    </td>
                    <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">商城价</span>
                    </div>
                    </td>
                    <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">市场价</span>
                    </div>
                    </td>
                    <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">库存</span>
                    </div>
                    </td>
                    <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">所属品牌</span>
                    </div>
                    </td>
                    <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div
                            align="center">
                        <span class="STYLE10">基本操作</span>
                    </div>
                    </td>
                </tr>
                <c:forEach items="${products1}" var="product" varStatus="status">
                    <tr>
                        <td height="20" bgcolor="#FFFFFF">
                            <div align="center">
                                <input type="checkbox" name="pid" id="pid" value="" />
                            </div>
                        </td>
                        <td height="20" bgcolor="#FFFFFF" class="STYLE6">
                            <div align="center">
                                <span class="STYLE19">${product.pid}</span>
                            </div>
                        </td>
                        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
                            <div align="center">${product.pname}</div>
                        </td>
                        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
                            <div align="center">${product.estoreprice}</div>
                        </td>
                        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
                            <div align="center">${product.markprice}</div>
                        </td>
                        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
                            <div align="center">${product.pnum}</div>
                        </td>
                        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
                            <div align="center">
                                <%
                                    Product product= (Product) pageContext.getAttribute("product");
                                    out.print((new CategoryService()).getCategoryByCid(product.getCid()).getCname());
                                    //System.out.println(product);
                                %>
                            </div>
                                <%--<%out.print("<div align=\"center\">"+(new CategoryService()).getCategoryByCid(products.get(sta).getCid()).getCname()+"</div>");%>--%>
                        </td>
                        <td height="20" bgcolor="#FFFFFF">
                            <div align="center" class="STYLE21">
                                <%
                                    //out.print();
                                %>
                                <a href="${pageContext.request.contextPath }/admin/product/modify_product.jsp?mo=${product.pid}">编辑</a> |
                                <a href="${pageContext.request.contextPath }/Product?op=delete&de=${product.pid}">删除</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            </td>
        </tr>
</table>
</form>
</body>
</html>
