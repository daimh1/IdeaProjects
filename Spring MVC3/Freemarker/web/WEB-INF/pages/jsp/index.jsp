<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <script src="resources/js/jquery.js"></script>
  <script>
      function  hint() {
          $.ajax(
                {
                    type:"POST",
                    url:"${pageContext.request.contextPath}/user/findUserById",
                    //contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    //data:"id=1",
                    contentType:"application/json;charset=utf-8",
                    data:'{"id":"1","username":"xxx","age":"23"}',
                    success:function(data){
                        alert(data.age)
                    }
                }
              );


      }

  </script>
</head>
<body>
google 一下，你就知道
<form action="" method="post">
  <input id="searchbox" type="text" name="keyword" onkeyup="hint()"><input type="submit" value="搜索">
</form>
</body>
</html>
