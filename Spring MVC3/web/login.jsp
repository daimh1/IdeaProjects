<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$

  <form action="${pageContext.request.contextPath}/user/login3.do" method="post">
    用户<input type="text" name="username" /><br>
    密码<input type="password" name="password" /><br>
    年龄<input type="text" name="age" value="18" /><br>
    生日  <input type="text" name="birthday"   /><br>

    老师姓名<input type="text" name="teacher.tname" /><br>

    兴趣爱好 吃饭<input type="checkbox" name="hobby" value="java">
           睡觉<input type="checkbox" name="hobby" value="c++">
           打豆豆<input type="checkbox" name="hobby" value="python">

    <br>
    <hr>鞋子信息<br>
    鞋子品牌    <input type="text" name="shoes[0].brand"> 鞋子尺码<input type="text" name="shoes[0].size" value="40"><br>
    鞋子品牌    <input type="text" name="shoes[1].brand"> 鞋子尺码<input type="text" name="shoes[1].size" value="40"><br>
    鞋子品牌    <input type="text" name="shoes[2].brand"> 鞋子尺码<input type="text" name="shoes[2].size" value="40"><br>

    <input type="submit"/>
  </form>

  </body>
</html>
