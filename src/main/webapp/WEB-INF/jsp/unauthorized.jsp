<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/css/style.css"/>
</head>
<body>
<div class="workingroom">
    权限不足，具体原因:${ex.message}
    <br>
    <a href="#" onClick="javascript:history.back()">返回</a>
</div>
</body>
</html>
