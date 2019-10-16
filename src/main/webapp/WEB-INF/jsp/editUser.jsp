<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑用户</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css"/>
    <!--引入bootstrap-->
    <script type="text/javascript" src="../static/js/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap/3.3.6/bootstrap.css">
    <script type="text/javascript" src="../static/js/bootstrap/3.3.6/bootstrap.js"></script>
    <style>
        div table {
            width: 600px;
            margin: 10px auto;
        }

        div input {
            margin: 10px;
        }
    </style>
</head>
<body>
<div class="workingDiv">
    <%@ include file="include/menu.jsp" %>

    <div class="right">
        <div class="addOrEdit">
            <form action="updateUser" method="post">
                用户名:<input type="text" value="${user.name}" name="name" class="form-control" style="width:200px"><br>
                密码: <input type="password" placeholder="如果不修改请置空" name="password" class="form-control"
                           style="width:200px"/><br>
                配置角色:<br>
                <c:forEach items="${roles}" var="role">
                    <c:set var="hasRole" value="fasle"></c:set>
                    <c:forEach items="${currentRoles}" var="curRole">
                        <c:if test="${role.id==curRole.id}">
                            <c:set var="hasRole" value="true"></c:set>
                        </c:if>
                    </c:forEach>
                    <input type="checkbox"  ${hasRole?'checked':''} value="${role.id}" name="roleIds">${role.name}<br>
                </c:forEach>
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" value="修改" class="form-control" style="width:80px;">
            </form>
        </div>
    </div>
</div>
</body>
</html>
