<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>角色编辑</title>
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
        <form action="updateRole">
            角色名称:<input type="text" name="name" value="${role.name}" class="form-control" style="width:200px;"><br>
            角色描述:<input type="text" name="desc_" value="${role.desc_}" class="form-control" style="width:200px;"><br>
            配置权限:<br>
            <c:forEach items="${permissions}" var="permission">
                <c:set var="hasRole" value="false"/>
                <c:forEach items="${currentPermissions}" var="curPermission">
                    <c:if test="${permission.id==curPermission.id}">
                        <c:set var="hasRole" value="true"/>
                    </c:if>
                </c:forEach>
                <input type="checkbox" ${hasRole?"checked":""} value="${permission.id}" name="permissionIds">${permission.name}<br>
            </c:forEach>
            <input type="hidden" name="id" value="${role.id}">
            <input type="submit" value="修改" class="form-control" style="width:80px;margin-top:10px;">
        </form>

    </div>

</div>
</body>
</html>
