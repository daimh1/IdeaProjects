<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath }/user/css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--webfonts-->
    <!--//webfonts-->
    <%--<script src="js/setDate.js" type="text/javascript"></script>--%>
</head>
<script>
    var ret1=true;
    var ret2=true;
    var ret3=true;
    var ret4=true;
    function  check1() {
        var inputBox = document.getElementById("username");
        //alert(inputBox.value)
        //用户名\w长度必须为6-8位
        ret1= /^((\w|[\u4E00-\u9FA5]){6,10})$/.test(inputBox.value);
        if(ret1){
            var xhr=new XMLHttpRequest();

            xhr.onreadystatechange=function () {
                if(xhr.readyState==4&&xhr.status==200){
                    var context=xhr.responseText;
                    console.log(context);
                    if(context=="valid"){ret1=true;}
                    else {alert("用户名重复");}
                }
            }
            xhr.open("GET","http://192.168.3.56/Ajax?username="+inputBox.value,true);
            xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
            xhr.send(null);
        }
        if(!ret1){alert("请输入6-10位长度的用户名");}


        if(ret1&&ret2&&ret3&&ret4){
            document.getElementById('button1').disabled=false;
        }else {
            document.getElementById('button1').disabled=true;
        }
    }
    function check2() {
        var inputBox = document.getElementById("password");
        ret2=/^((\w|[\u4E00-\u9FA5]){4,12})$/.test(inputBox.value);

        if(!ret2){alert("请输入4-12位长度的密码");}

        if(ret1&&ret2&&ret3&&ret4){
            document.getElementById('button1').disabled=false;
        }else {
            document.getElementById('button1').disabled=true;
        }
    }

    function check3() {
        var inputBox = document.getElementById("email");
        ret3=/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(inputBox.value);
        if(!ret3){alert("请输入正确邮箱");}

        if(ret1&&ret2&&ret3&&ret4){
            document.getElementById('button1').disabled=false;
        }else {
            document.getElementById('button1').disabled=true;
        }
    }

    function check4() {
        var inputBox = document.getElementById("birthday");
        ret4=/^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/.test(inputBox.value);
        if(!ret4){alert("请输入正确日期");}
        if(ret1&&ret2&&ret3&&ret4){
            document.getElementById('button1').disabled=false;
        }else {
            document.getElementById('button1').disabled=true;
        }
    }
</script>
<body>
<div class="main" align="center">
    <div class="header">
        <h1>创建一个免费的新帐户！</h1>
    </div>
    <p></p>
    <form method="post" action="${pageContext.request.contextPath }/UserRegister">
        <input type="hidden" name="op" value="regist" />
        <ul class="left-form">
            <li>
                ${msg.error.username }<br/>
                <input type="text" id="username" name="username" placeholder="请输入6-8位长度用户名" value="${msg.username}" required="required" onblur="check1()"/>
                <a href="#" class="icon ticker"> </a>
                <div class="clear"> </div>
            </li>
            <li>
                ${msg.error.nickname }<br/>
                <input type="text" name="nickname" placeholder="昵称" value="${msg.nickname}" required="required"/>
                <a href="#" class="icon ticker"> </a>
                <div class="clear"> </div>
            </li>
            <li>
                ${msg.error.email }<br/>
                <input type="text" id="email" name="email" placeholder="邮箱" value="${msg.email}" required="required"  onblur="check3()"/>
                <a href="#" class="icon ticker"> </a>
                <div class="clear"> </div>
            </li>
            <li>
                ${msg.error.password }<br/>
                <input type="password" id="password" name="password" placeholder="密码" value="${msg.password}" required="required" onblur="check2()"/>
                <a href="#" class="icon into"> </a>
                <div class="clear"> </div>
            </li>
            <li>
                ${msg.error.birthday }<br/>
                <input type="text" id="birthday" placeholder="出生日期 2018-08-08" name="birthday" value="${msg.birthday}" size="15" onblur="check4()"/>
                <div class="clear"> </div>
            </li>
            <li>
                <button id="button1" type="submit" value="创建账户">
                    创建账户   <%--<input type="submit" value="创建账户">--%>
                </button>
                <div class="clear"> </div>
            </li>
        </ul>

        <div class="clear"> </div>

    </form>

</div>
<!-----start-copyright---->

<!-----//end-copyright---->

</body>

</html>