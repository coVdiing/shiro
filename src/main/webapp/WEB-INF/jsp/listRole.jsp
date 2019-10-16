<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>角色管理</title>
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
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>id</th>
                <th>角色名称</th>
                <th width="100px">角色描述</th>
                <th>权限</th>
                <th width="100px">编辑
                <th width="100px">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.name}</td>
                    <td>${role.desc_}</td>
                    <td>${role_permissions[role]}</td>
                    <td><a href="editRole?id=${role.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href="deleteRole?id=${role.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="addRole" method="post">
            <input type="text" name="name" placeholder="角色名称" class="form-control" style="width:200px"/><br>
            <input type="text" name="desc_" placeholder="角色描述" class="form-control" style="width:200px"/><br>
            <input type="submit" value="增加" class="form-control" style="width:80px;"/>
        </form>
    </div>

</div>

</body>
</html>
