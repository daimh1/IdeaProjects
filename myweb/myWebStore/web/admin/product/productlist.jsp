<%@ page import="com.webstore.bean.Product" %>
<%@ page import="com.webstore.service.ProductService" %>
<%@ page import="com.webstore.utils.PageHelper" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.CategoryService" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
	String num = request.getParameter("num");
	if (num==null||num.isEmpty()){

		num="1";
	}

	ProductService productService=new ProductService();
	PageHelper<Product> pageHelper= null;
	try {
		pageHelper = productService.findProductListByPagenumber(num);
		request.setAttribute("page",pageHelper);

	} catch (SQLException e) {
		e.printStackTrace();
	}

	List<Product> products=null;
	products=pageHelper.getRecords();

	//request.setAttribute("products",products);
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
					<c:forEach items="${page.records }" var="product" varStatus="status">
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
								%></div>
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
											<a href="${pageContext.request.contextPath }/admin/product/productlist.jsp?num=1">首页</a>
											</span>
										</div>
									</td>
									<td width="49">
										<div align="center">
											<span class="STYLE22">
											<a href="${pageContext.request.contextPath }/admin/product/productlist.jsp?num=${page.prevPageNum}">上一页</a>
											</span>
										</div>
									</td>
									<td width="49"><span class="STYLE22">
									    <div align="center">
											<span class="STYLE22">
											<a href="${pageContext.request.contextPath }/admin/product/productlist.jsp?num=${page.nextPageNum}">下一页</a>
											</span>
										</div>
									</span>
									</td>
									<td width="49">
										<div align="center">
											<span class="STYLE22"><a href="${pageContext.request.contextPath }/admin/product/productlist.jsp?num=${page.totalPageNum }">尾页</a></span>
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
		$().ready(function(){
			$("#checkbox11").click(function(){
				if($(this).attr("checked")){
					$(":checkbox").attr("checked",true);
				}else{
					$(":checkbox").attr("checked",false);
				}
			})
		})
		function jump() {
			
			var num = document.getElementById("num").value;
			if (!/^[1-9][0-9]*$/.test(num)) {
				alert("请输入正确的页码");
				return;
			}
	
			if (num > ${page.totalPageNum}) {
				alert("页码超出范围");
				return;
			}
	
			window.location.href = "${pageContext.request.contextPath }/admin/product/productlist.jsp?num="
					+ num;
	
		}
	</script>
</body>
</html>
