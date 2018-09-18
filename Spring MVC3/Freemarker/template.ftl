<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Welcome ${name}</h1>
<hr>
<#list  userlist as user>

    <#if user.username=="lisi">
        <a>${user.username}|${user.password}</a>
    <#else >
        ${user.username}|${user.password}
    </#if>

</#list>
</body>
</html>