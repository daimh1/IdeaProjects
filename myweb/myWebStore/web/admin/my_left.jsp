<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/5
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>left</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/chili-1.7.pack.js"></script>
    <script type="text/javascript" src="js/jquery.easing.js"></script>
    <script type="text/javascript" src="js/jquery.dimensions.js"></script>
    <script type="text/javascript" src="js/jquery.accordion.js"></script>
    <script language="javascript">
        jQuery().ready(function(){
            jQuery('#navigation').accordion({
                header: '.head',
                navigation1: true,
                event: 'click',
                fillSpace: true,
                animated: 'bounceslide'
            });
        });
    </script>
    <style type="text/css">
        <!--
        body {
            margin:0px;
            padding:0px;
            font-size: 12px;
        }
        #navigation {
            margin:0px;
            padding:0px;
            width:147px;
        }
        #navigation a.head {
            cursor:pointer;
            background: beige;
            display:block;
            font-weight:bold;
            margin:0px;
            padding:5px 0 5px;
            text-align:center;
            font-size:12px;
            text-decoration:none;
        }
        #navigation ul {
            border-width:0px;
            margin:0px;
            padding:0px;
            text-indent:0px;
        }
        #navigation li {
            list-style:none; display:inline;
        }
        #navigation li li a {
            display:block;
            font-size:12px;
            text-decoration: none;
            text-align:center;
            padding:3px;
        }
        #navigation li li a:hover {
            background:url(/..) repeat-x;
            border:solid 1px #adb9c2;
        }
        -->
    </style>

</head>
<body>
<div  style="height:100%;">
    <ul id="navigation">
        <li> <a class="head">商品管理</a>
            <ul>
                <li><a href="/admin/product/addproduct.jsp" target="rightFrame">添加商品</a></li>
                <li><a href="/admin/product/productlist.jsp" target="rightFrame">查看/修改商品</a></li>
                <li><a href="/admin/product/search_product.jsp" target="rightFrame">搜索商品</a></li>
            </ul>
        </li>
        <li> <a class="head">分类管理</a>
            <ul>
                <li><a href="/admin/category/addcategory.jsp" target="rightFrame">添加分类</a></li>
                <li><a href="/admin/category/category.jsp" target="rightFrame">查看/删除分类</a></li>
            </ul>
        </li>
        <li> <a class="head">订单管理</a>
            <ul>
                <li><a href="/bookstore/admin/OrderServlet?op=findAllOrder&num=1" target="rightFrame">查询/修改订单</a></li>
            </ul>
        </li>
        <li> <a class="head">系统用户管理</a>
            <ul>
                <li><a href="/admin/admin_account/admin_add.jsp" target="rightFrame">添加系统用户</a></li>
                <li><a href="/admin/admin_account/adminlist.jsp" target="rightFrame">查看/修改系统用户</a></li>
            </ul>
        </li>
        <li> <a class="head">注册用户管理</a>
            <ul>
                <li><a href="/admin/admin_account/admin_add.jsp" target="rightFrame">添加普通用户</a></li>
                <li><a href="/admin/admin_account/adminlist.jsp" target="rightFrame">查看普通注册用户</a></li>
            </ul>
        </li>
        <li> <a class="head">版本信息</a>
            <ul>
                <li><a href="/bookstore/admin/welcome.jsp"  target="rightFrame">版本号</a></li>
                <li><a href="/bookstore/admin/welcome.jsp"  target="rightFrame">联系我们</a></li>
                <li><a href="/bookstore/admin/welcome.jsp"  target="rightFrame">公司信息</a></li>
                <li><a href="/bookstore/admin/welcome.jsp"  target="rightFrame">个人信息</a></li>

            </ul>
        </li>
    </ul>
</div>
</body>

</html>
