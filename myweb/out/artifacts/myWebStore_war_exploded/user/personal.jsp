<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shoes Store - Shopping Cart</title>
<meta name="keywords" content="shoes store, shopping cart, free template, ecommerce, online shop, website templates, CSS, HTML" />
<meta name="description" content="Shoes Store, Shopping Cart, online store template " />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

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
         	
        	<h3>个人资料</h3>
			<hr />
			<br />
			<!-- 
				 （仅限修改昵称，密码，邮箱和出生日期）
				 nickname
				 password
				 email
				 birthday
			 -->
			<form action="${pageContext.request.contextPath }/User?op=modify" method="post">
				<input type="hidden" name="uid" value="${session_user.uid }"/>
				用&nbsp;户&nbsp;名： ${session_user.username }<input type="hidden" name="username" value="${session_user.username }"/>
				<br /> <br />
				昵&nbsp;&nbsp;&nbsp;&nbsp;称：<input type="text" name="nickname" value="${session_user.nickname }">
				<br /><br />
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="${session_user.password }"/>
				<br /><br />
				邮&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" name="email" value="${session_user.email }"/>
				<br /> <br />
				出生日期：<input type="text" name="birthday" value="${session_user.birthday}"/>
				<br /><br />
				头像： ${""}
				<br /><br />
				<%-- 注册时间： ${user.updatetime } --%>
				<br /><br />
				<%-- <span>请准确填写您的信息，确保货物准确到达</span>
				<br /><br />
				详细地址 <input type="text" style="width: 400px" name="address" value="${address }"><span>*</span>
				<br /><br />
				联系电话 <input type="text" name="tel" value="${tel }"><span>*</span>
				<br /><br />
				 联系QQ&nbsp;&nbsp;&nbsp;<input type="text" name="qq" value="${qq }">
				 <br /><br /> --%>
				<input type="submit" value="保存填写" id="submit">
				<input type="reset" value="撤销重写" id="reset">
			</form>
 
         
                     
			</div>
        <div class="cleaner"></div>
    </div> 
    
    <div id="templatemo_footer">
		    Copyright (c) 2016 <a href="#">Web商城</a> | <a href="#">Web工作室</a>	
    </div> 
    
</div> 
</div>

</body>
</html>