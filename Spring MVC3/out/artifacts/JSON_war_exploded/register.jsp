<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/8
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/jquery.js"></script>

    <script type="text/javascript">



        function  register2() {
            var username =document.getElementById("username").value;
            var password =document.getElementById("password").value;
            var age =document.getElementById("age").value;

            $.ajax({
                type:"POST",
                url:"${pageContext.request.contextPath}/user/register",
                contentType:"application/json;charset=utf-8",
                data:"{"+"\"username\":\""+username+"\",\"password\":\""+password+"\",\"age\":\""+age+"\"}",
                success:function (data) { //此处已经是一个json的对象了
                    // alert(data.success)
                    if (data.success==0){
                        //把data.msg里的错误信息显示出来
                        alert(data.msg.password)
                    }else {
                        //跳转到登录页面
                    }
                }

            });

        }
    </script>
</head>
<body>

<%--action="${pageContext.request.contextPath}/user/register.do" method="post"--%>

<form >
    <table border="1" width="600">
        <tr>
            <td>*用户名：</td>
            <td><input type="text" name="username" id="username"/> <span id="usernamemsg"></span></td>
        </tr>
        <tr>
            <td>*密码:</td>
            <td><input type="password" name="password"   id="password"/> <span id="passwordmsg"></span></td>
        </tr>

        <tr>
            <td>*age:</td>
            <td><input type="text" name="age"  id="age" /><span id="agemsg"></span> </td>
        </tr>

        <tr>
            <td><input type="button"  value="提交注册信息" onclick="register2()"/></td> <%--//"--%>
            <td></td>
        </tr>
    </table>
</form>

</body>
</html>
