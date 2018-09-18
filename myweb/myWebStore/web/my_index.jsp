<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/4
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    CategoryService categoryService=new CategoryService();
    List<Category> categoryList=categoryService.categoryList();
    request.setAttribute("categories",categoryList);
  %>
  <a href="/admin/index.jsp">进入管理员界面</a>
  <a href="index.jsp">主页</a>
  <a href="${pageContext.request.contextPath}/user/myaccount.jsp">我的个人中心</a>
  <a href="${pageContext.request.contextPath}/userlogin.jsp">登录</a>
  <a href="${pageContext.request.contextPath}/userRegister.jsp">注册</a>
  <a href="${pageContext.request.contextPath}/logout">注销</a>
  <a href="${pageContext.request.contextPath }/CartServlet?op=findCart">购物车</a>
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
                    <a href="${pageContext.request.contextPath }/ProductServlet?op=byCid&cid=${category.cid}">${category.cname}</a>
                  </li>
                </c:if>
              </c:if>
              <c:if test="${vs.index==0 }">
                <li class="first">
                  <a href="${pageContext.request.contextPath }/ProductServlet?op=byCid&cid=${category.cid}">${category.cname}</a>
                </li>
              </c:if>
              <c:if test="${vs.index == fn:length(categories)-1 }">
                <li class="last">
                  <a href="${pageContext.request.contextPath }/ProductServlet?op=byCid&cid=${category.cid}">${category.cname}</a>
                </li>
              </c:if>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
