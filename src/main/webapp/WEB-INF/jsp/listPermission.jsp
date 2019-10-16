<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>权限管理</title>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css"/>
    <!--引入bootstrap-->
    <script type="text/javascript" src="../static/js/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap/3.3.6/bootstrap.css">
    <script type="text/javascript" src="../static/js/bootstrap/3.3.6/bootstrap.js"></script>
    <style>
        div table {
            width: 600px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div class="workingDiv">
    <%@ include file="include/menu.jsp" %>
    <div class="right">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>id</th>
                    <th>权限名称</th>
                    <th>权限描述</th>
                    <th>权限对应的路径</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${permissions}" var="permission">
                    <tr>
                        <td>${permission.id}</td>
                        <td>${permission.name}</td>
                        <td>${permission.desc_}</td>
                        <td>${permission.url}</td>
                        <td><a href="editPermission?id=${permission.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                        <td><a href="deletePermission?id=${permission.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="addPermission" method="post">
            <input type="text" name="name" placeholder="权限名称" class="form-control" style="width:200px;"><br>
            <input type="text" name="desc_" placeholder="权限描述" class="form-control" style="width:200px;"><br>
            <input type="text" name="url" placeholder="权限对应的url" class="form-control" style="width:200px;"><br>
            <input type="submit" value="增加">
        </form>
    </div>
</div>
</body>
</html>
