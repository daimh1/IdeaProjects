<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.ShoppingCartService" %>
<%@ page import="com.webstore.bean.User" %>
<%@ page import="com.webstore.bean.ShoppingCart" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Shopping Cart</title>
<meta name="keywords" content="shoes store, shopping cart, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Shopping Cart, online store template " />
<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="../css/ddsmoothmenu.css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/ddsmoothmenu.js">



</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
	<style type="text/css">
		#my_font1 a{
			color: #3b3736;
		}
		.product_price a{
			color: #3b3736;
			font-weight: bold;
		}
	</style>
</head>

<body>
<c:if test="${empty categories }">
	<%
		CategoryService categoryService=new CategoryService();
		List<Category> categoryList=categoryService.categoryList();
		request.setAttribute("categories",categoryList);
	%>
</c:if>
<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="http://localhost/${pageContext.request.contextPath }">Online Food Store</a></h1></div>
        <div id="header_right">
        	<p id="my_font1">
	        <c:if test="${!empty session_user }">
	        	<a href="${pageContext.request.contextPath }/user/personal.jsp">我的个人中心</a> |
	        </c:if>
	        <a href="${pageContext.request.contextPath }/CartServlet?op=findCart">购物车</a> |
	        <c:if test="${session_user == null }">
	        	<a href="${pageContext.request.contextPath }/userlogin.jsp">登录</a> |
	        	<a href="${pageContext.request.contextPath }/userRegister.jsp">注册</a>
	        </c:if>
	        <c:if test="${!empty sessionScope.session_user }">
	        	${session_user.nickname }
	        	<a href="${pageContext.request.contextPath }/logout">注销</a></p>
	        </c:if>
	        </p>
	        <p id="my_font1">
		        <c:if test="${!empty session_user }">
		        	<a href="${pageContext.request.contextPath }/user/mylist.jsp">我的订单</a> |
		        </c:if>
	        </p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="${pageContext.request.contextPath }/MainServlet" class="selected">主页</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="templatemo_search">
            <form action="${pageContext.request.contextPath }/frontProduct" method="get">
              <input type="hidden" name="op" value="search"/>
              <input type="text" value="${pname }" name="pname" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>品牌</h3>   
                <div class="content"> 
                	<ul class="sidebar_list">
                    	<c:forEach items="${categories }" var="category" varStatus="vs">
                			<c:if test="${vs.index !=0}">
                				<c:if test="${vs.index != fn:length(categories)-1 }">
                					<li>
                						<a href="${pageContext.request.contextPath }/frontProduct?op=byCid&cid=${category.cid}">${category.cname}</a>
                					</li>
                				</c:if>
                			</c:if>
                			<c:if test="${vs.index==0 }">
                				<li class="first">
                					<a href="${pageContext.request.contextPath }/frontProduct?op=byCid&cid=${category.cid}">${category.cname}</a>
                				</li>
                			</c:if>
                			<c:if test="${vs.index == fn:length(categories)-1 }">
                				<li class="last">
                					<a href="${pageContext.request.contextPath }/frontProduct?op=byCid&cid=${category.cid}">${category.cname}</a>
                				</li>
                			</c:if>
                		</c:forEach>
                    </ul>
                </div>
            </div>
            
        </div>
        <div id="content" class="float_r">
        	<h4><img src="${pageContext.request.contextPath }/images/cart.gif" />购物车</h4>
        	<form action="">
	        	<table width="680px" cellspacing="0" cellpadding="5">
	                   	  <tr bgcolor="#ddd">
	                        	<th width="220" align="left">图片 </th> 
	                        	<th width="180" align="left">描述 </th> 
	                       	  	<th width="100" align="center">数量 </th> 
	                        	<th width="60" 	align="right">价格 </th> 
	                        	<th width="60" 	align="right">总价 </th> 
	                        	<th width="90"> </th>
	                            
	                      </tr>
	                      <c:if test="${!empty session_user }">
							  <%
								  ShoppingCartService shoppingCartService=new ShoppingCartService();
								  User user= (User) session.getAttribute("session_user");
								  //ShoppingCart shoppingCart=shoppingCartService.findShoppingcartByUidAndPid(user.getUid(),)

								  session.setAttribute("shoppingCart",shoppingCartService.cartLists(user.getUid()));
							  %>
		                      <c:forEach items="${shoppingCart}" var="item">
									<tr>
			                        	<td><img src="../file/${item.imgurl }" style="width: 200px;height: 180px" alt="" /></td>
			                        	<td>${item.describtion }</td>
			                            <td align="center"><font style="width: 20px; text-align: right" >${item.num }</font> </td>
			                            <td align="right">${item.perprice } </td>
			                            <td align="right">${item.totalprice } </td>
			                            <td align="center"> 
			                            	<a href="${pageContext.request.contextPath }/addtocart?op=delete&imgid=${item.imgurl}&uid=${session_user.uid}&num=${item.num}">
			                            		<!-- <img src="images/remove_x.gif" alt="remove" /> <br />-->
			                            		Remove
			                            	</a> 
			                            </td>
									</tr>                      
		                      </c:forEach>
	                      </c:if>
						</table>
					</form>
                    <div style="float:right; width: 255px; margin-top: 20px;">
                    
                    <c:if test="${!empty shoppingCart}"><p>
						<a href="${pageContext.request.contextPath }/Order?op=addshoppingcart">立即购买</a>
					</p></c:if>
                    <p><a href="${pageContext.request.contextPath}/index.jsp">继续购物</a></p>
                    	
                    </div>
			</div>
        <div class="cleaner"></div>
    </div> 
    
    <div id="templatemo_footer">
		    Copyright (c) 2016 <a href="#">food商城</a> | <a href="#">版权所有</a>
    </div> 
    
</div> 
</div>

</body>
</html>