<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="com.webstore.bean.Product" %>
<%@ page import="com.webstore.service.ProductService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store, free template</title>
<meta name="keywords" content="shoes store, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store is a free ecommerce template provided " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="nivo-slider.css" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

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
    	<div id="site_title"><h1><a href="${pageContext.request.contextPath }">Online food Store</a></h1></div>
        <div id="header_right">
        	<p id="my_font1">
        	<c:if test="${!empty session_user }">
		        <a href="${pageContext.request.contextPath}/user/personal.jsp">我的个人中心</a> |
        	</c:if>
	        <a href="${pageContext.request.contextPath }/CartServlet?op=findCart">购物车</a> |
	        <c:if test="${empty session_user }">
	        	<a href="${pageContext.request.contextPath}/userlogin.jsp">登录</a> |
	        	<a href="${pageContext.request.contextPath}/userRegister.jsp">注册</a></p>
	        </c:if>
	        <c:if test="${!empty session_user }">
	        	${session_user.nickname }
	        	<a href="${pageContext.request.contextPath}/logout">注销</a></p>
	        </c:if>
			<p  id="my_font1">
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
              <input type="submit" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
	<div class="copyrights">Collect from <a href="#" title="Web商城">Web商城</a></div>
    
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
        	<div id="slider-wrapper">
                <div id="slider" class="nivoSlider">
					<img src="my_img/Carousel_01.jpg" style="width: 680px;height: 310px" title=""/>
					<img src="my_img/Carousel_02.jpg" style="width: 680px;height: 310px" title=""/>
					<img src="my_img/Carousel_03.jpg" style="width: 680px;height: 310px" title=""/>
				</div>
                <div id="htmlcaption" class="nivo-html-caption">
                    <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.
                </div>
            </div>
            <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
            <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
            </script>
			<%
				ProductService productService=new ProductService();
				List<Product> productList= (List<Product>) request.getAttribute("productTop");
				if(productList==null){
					productList=productService.productList();
				}

				request.setAttribute("productTop",productList);
			%>
        	<h3>热门商品</h3>
        	<c:forEach items="${productTop }" var="product" varStatus="vs">
        		<div class="${vs.index % 3 != 2?'product_box':'product_box no_margin_right' }">
		            <h3>${product.pname }</h3>
	            	<a href="${pageContext.request.contextPath }/frontProduct?op=findProductById&pid=${product.pid}">
	            		<img src="file/${product.imgurl }" width="200" height="200" alt="" title="${product.pname }"/>
	            	</a>
	                <p style="width: 200px;overflow: hidden;white-space: nowrap; text-overflow: ellipsis;">
						<c:if test="${!empty product.descibe}">
							${product.descibe}
						</c:if>
						<c:if test="${empty product.descibe}">
							<br>
						</c:if>

					</p>
					<p class="product_price"><a>￥ ${product.estoreprice }</a></p>
	                <c:if test="${empty session_user }">
	                	<a href="javascript:login()" class="addtocart"></a>
	                </c:if>
	                <c:if test="${!empty session_user }">
	                	<a href="${pageContext.request.contextPath}/addtocart?op=add&pid=${product.pid}&uid=${session_user.uid}" class="addtocart"></a>
	                </c:if>
	                <a href="${pageContext.request.contextPath }/frontProduct?op=findProductById&pid=${product.pid}" class="detail"></a>
            	</div>
            	<c:if test="${vs.index % 3 == 2}">
            		<div class="cleaner"></div>
            	</c:if>
        	</c:forEach>
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	Copyright (c) 2016 <a href="#">Web商城</a> | <a href="#">Web工作室</a>
    </div>
</div>
</div>
	<script type="text/javascript">
		function login(){
			alert("请先登录");
			window.location.href="${pageContext.request.contextPath}/userlogin.jsp";
		}
	</script>
</body>
</html>