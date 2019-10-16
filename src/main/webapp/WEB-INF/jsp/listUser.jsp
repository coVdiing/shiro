<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<head>
    <link rel="stylesheet" type="text/css" href="../static/css/style.css"/>
    <!--引入bootstrap-->
    <script type="text/javascript" src="../static/js/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/bootstrap/3.3.6/bootstrap.css">
    <script type="text/javascript" src="../static/js/bootstrap/3.3.6/bootstrap.js"></script>
    <title>用户管理</title>
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
        <table class="table table-bordered" style="width:500px;">
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>密码</th>
                <th>加密盐</th>
                <th>角色</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${fn:substring(user.password,0,5)}...</td>
                    <td>${fn:substring(user.salt,0,5)}...</td>
                    <td>
                        <c:forEach items="${user_roles[user]}" var="role">
                            ${role.name}<br>
                        </c:forEach>
                    </td>
                    <td>
                        <a href="editUser?id=${user.id}"><span class="glyphicon glyphicon-edit"></span></a>
                    </td>
                    <td>
                        <a href="deleteUser?id=${user.id}"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="addOrEdit" style="margin:10px;width:400px;">
            <form action="addUser" method="post">
                <input placeholder="用户名" name="name" class="form-control" style="width:200px;"><br>
                <input placeholder="密码" type="password" name="password" class="form-control" style="width:200px;"><br>
                <input type="submit" value="增加" class="form-control" style="width:80px;">
            </form>
        </div>
    </div>
</div>
</body>
</html>
