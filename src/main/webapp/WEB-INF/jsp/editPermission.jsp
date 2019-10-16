<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>权限编辑</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css"/>
    <!--引入bootstrap-->
    <script type="text/javascript" src="../static/js/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap/3.3.6/bootstrap.css">
    <script type="text/javascript" src="../static/js/bootstrap/3.3.6/bootstrap.js"></script>
</head>
<body>
    <div class="workingDiv">
        <%@ include file="include/menu.jsp" %>

        <div class="right">
            <form action="updatePermission" method="post">
                权限名称:<input type="text" name="name" value="${permission.name}" class="form-control" style="width:200px;"><br>
                权限描述:<input type="text" name="desc_" value="${permission.desc_}" class="form-control" style="width:200px"><br>
                权限对应的URL:<input type="text" name="url" value="${permission.url}" class="form-control" style="width:200px"><br>
                <input type="hidden" value="${permission.id}" name="id">
                <input type="submit" value="修改" class="form-control" style="width:80px;">
            </form>
        </div>
    </div>

</body>
</html>
