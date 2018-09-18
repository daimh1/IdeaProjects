<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webstore.service.ProductService" %>
<%@ page import="com.webstore.bean.Product" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

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
    <script type="text/javascript">
        function checkInput() {
            var pid = document.getElementsByName("pid")[0];
            var pnum = document.getElementsByName("pnum")[0];
            var pname = document.getElementsByName("pname")[0];
            var estorePrice = document.getElementsByName("estorePrice")[0];
            var markPrice = document.getElementsByName("markPrice")[0];
            var description = document.getElementsByName("description")[0];
            // 商品号要为数字
            if (/^\d+$/.test(pid.value)) {
                // 库存要为数字
                if (/^\d+$/.test(pnum.value)) {
                    // 商品名不能为空
                    if (pname.value !== "") {
                        // 价格保留两位小数
                        if (/^\d+(\.\d{1,2})?$/.test(estorePrice.value) && /^\d+(\.\d{1,2})?$/.test(markPrice.value)) {
                            // 商品描述不能为空
                            if (description.value !== "") {
                                return true;
                            } else {
                                alert("商品描述为空，请重新输入...");
                                return false;
                            }
                        } else {
                            alert("请输入正确价格，仅需保留两位小数...");
                            return false;
                        }
                    } else {
                        alert("商品名为空，请重新输入...");
                        return false;
                    }
                } else {
                    alert("库存数输入错误，请输入数字...");
                    return false;
                }
            } else {
                //alert("商品号输入错误，请输入数字...");
                return true;
            }
        }
    </script>
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
    request.setAttribute("this_imgurl",obj.getImgurl());
        /*out.print("<tr>");
        out.print("<td>"+categories.get(n).getCid()+"</td>"+"<td>"+categories.get(n).getCname()+"</td>"+"<td><a href='/Category?op=delete&de="+i+"'>删除</a>/<a href='/category_modify.jsp?mo="+i+"'></td>");
        out.println("</tr>");*/
%>
<form method="post"
      action="${pageContext.request.contextPath }/Product?op=modify" onsubmit="return checkInput()">
    <%--<form method="post" action="${pageContext.request.contextPath }/ProductServlet">--%>
    <%--<input type="hidden" name="op" value="updateProduct"/>--%>
    <%--<input type="hidden" name="imgUrl" value="${product.imgUrl }">--%>

    <table width="100%" border="0" align="center" cellpadding="0"
           cellspacing="0">
        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="24" bgcolor="#353c44">
                            <table width="100%"
                                   border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td>
                                        <table width="100%" border="0" cellspacing="0"
                                               cellpadding="0">
                                            <tr>
                                                <td width="6%" height="19" valign="bottom">
                                                    <div
                                                            align="center">
                                                        <img src="images/tb.gif" width="14" height="14"/>
                                                    </div>
                                                </td>
                                                <td width="94%" valign="bottom"><span class="STYLE1">
														修改商品</span>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <div align="right">
											<span class="STYLE1"> 
												 
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
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_1"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">品牌</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div align="left">
                                <select name="cid" id="st" onchange="change()">
                                    <%
                                        CategoryService categoryService=new CategoryService();
                                        List<Category> categories=categoryService.categoryList();
                                        String cname= (String) request.getAttribute("this_cname");
                                        for(int i=0;i<categories.size();i++){
                                            if(cname.equals(categories.get(i).getCname())){
                                                out.print("<option value=\""+categories.get(i).getCid()+"\"  selected = \"selected\" >"+categories.get(i).getCname()+"</option>");
                                            }else{
                                            out.print("<option value=\""+categories.get(i).getCid()+"\">"+categories.get(i).getCname()+"</option>");}
                                        }

                                    %>
                                </select>
                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_2"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">商品号</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">

                                <input type="text " name="pid" value="${this_pid}" readonly="readonly"/>

                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_3"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">总库存</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">

                                <input type="text " name="pnum" value="${this_pnum}"/>

                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_4"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">商品名称</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">

                                <input type="text " name="pname" width="200" value="${this_pname}"/>

                            </div>
                        </td>

                    </tr>


                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_5"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">商城价:￥</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">

                                <input type="text " name="estorePrice" value="${this_estoreprice}"/><br>

                            </div>
                        </td>

                    </tr>


                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_6"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">市场价:￥</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">

                                <input type="text " name="markPrice" value="${this_markprice}"/><br>

                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11_7"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">图片</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">


                                <img width="200px" height="180px" src="../../file/${this_imgurl}">
                                     <%--src="${pageContext.request.contextPath}/file/${product.imgUrl}"/>--%>
                                <input type="file" name="imgUrl" value="${this_imgurl}"/><br>

                            </div>
                        </td>

                    </tr>


                    <tr>
                        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10">
                            <div
                                    align="center">
                                <input type="checkbox" name="checkbox" id="checkbox11"/>
                            </div>
                        </td>
                        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="center">
                                <span class="STYLE10">商品描述</span>
                            </div>
                        </td>
                        <td width="80%" height="20" bgcolor="d3eaef" class="STYLE6">
                            <div
                                    align="left">

                                <textarea name="description" cols="80" rows="5">${this_descibe}</textarea>
                                <%--<input type="hidden" name="estoreprice" value="${this_estoreprice}"/>--%>
                                <%--<input type="hidden" name="markprice" value="${this_markprice}">--%>
                            </div>
                        </td>

                    </tr>

                </table>
            </td>
        </tr>

        <tr>
            <td height="30">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="33%">
                            <div align="left">
                            </div>
                        </td>
                        <td width="67%">
                            <div align="right">
                                <input type="button" onclick="history.go(-1);" value="返回"/>
                                <input type="submit" value="修改"/>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</form>
</body>
</html>


