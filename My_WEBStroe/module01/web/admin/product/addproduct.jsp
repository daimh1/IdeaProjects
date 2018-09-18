<%@ page import="com.webstore.service.CategoryService" %>
<%@ page import="com.webstore.bean.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/6
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <style type="text/css">
        #result{
            width: 200px;
            height:200px;
            border:1px solid #eee;
        }
    </style>
</head>
<body>
<h2>添加商品</h2>
<form action="/addProduct" method="post" enctype="multipart/form-data">
    <table>
        <tr><td>商品名：</td><td><input type="text" name="pname"></td></tr>
        <tr><td>网上售价：</td><td><input type="text" name="estoreprice"></td></tr>
        <tr><td>市场价：</td><td><input type="text" name="markprice"></td></tr>
        <tr><td>库存：</td><td><input type="text" name="pnum"></td></tr>
        <tr><td>类别：</td><td><select name="search_cid">
            <option value=""></option>
            <%
                CategoryService categoryService=new CategoryService();
                List<Category> categories=categoryService.categoryList();
                for(int i=0;i<categories.size();i++){
                    out.print("<option value=\""+categories.get(i).getCid()+"\">"+categories.get(i).getCname()+"</option>");
                }

            %>
        </select></td></tr>
        <%--<tr><td>上传图片：</td><td><input type="file" name="imgurl"></td></tr>--%>
        <tr><td>上传图片：</td><td><input id="picture" type="file" name="imgurl" onchange="selectFile()"></td><td><div id = "result"></div></td></tr>
        <tr><td>详细介绍：</td><td><textarea name="descibe" style="width:400px;height:120px;"></textarea></td></tr>

    </table>
    <input type="submit" value="提交">
</form>
<script>
    var form = new FormData();//通过HTML表单创建FormData对象
    var url = '127.0.0.1:80/';
    function selectFile(){
        var files = document.getElementById('picture').files;
        console.log(files[0]);
        if(files.length == 0){
            return;
        }
        var file = files[0];
        //把上传的图片显示出来
        var reader = new FileReader();
        // 将文件以Data URL形式进行读入页面
        console.log(reader);
        reader.readAsBinaryString(file);
        reader.onload = function(f){
            var result = document.getElementById("result");
            var src = "data:" + file.type + ";base64," + window.btoa(this.result);
            result.innerHTML = '<img src ="'+src+'"/>';
        }
        console.log('file',file);
        form.append('file',file);
        console.log(form.get('file'));
    }
</script>
</body>
</html>
