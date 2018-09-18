<%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/8/21
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/jquery.js"></script>
    <script type="text/javascript">
        function  hint() {
            var pro =document.getElementById("province").value;
            console.log(pro)
            var country={
                name:"china",
                province:[{
                    name:"广东",
                    city:[{name:"深圳"},{name:"广州"}]
                }],
                province:[{
                    name:"福建",
                    city:[{name:"福州"},{name:"厦门"}]
                }]
            }
            $.ajax(
                {
                    type:"POST",
                    url:"${pageContext.request.contextPath}/findcity",
                    //contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    //data:"id=1",
                    contentType:"application/json;charset=utf-8",
                    data:{"province":pro}

                }
            );


        }
    </script>
</head>
<body>
    <select name="province" id="province" onchange="hint()">
        <option value="1">广东</option>
        <option value="2">福建</option>
    </select>

</body>
</html>
