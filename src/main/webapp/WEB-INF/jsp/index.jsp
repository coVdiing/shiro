<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="static/css/style.css"/>
</head>

<body>
<div class="workingroom">
    <div class="loginDiv">
        ${request.contextPath}
        <c:if test="${!empty subject.principal}">
            <span>你好!${subject.principal}</span>
            <a href="doLogout">退出</a>
        </c:if>
        <c:if test="${empty subject.principal}">
            <a href="login">登录</a>
        </c:if>
    </div>
    <ul>
        <li><a href="listProduct">查看产品</a></li>
        <li><a href="deleteProduct">删除产品</a></li>
        <li><a href="deleteOrder">删除订单</a></li>
        <li><a href="config/listUser">用户管理</a></li>
    </ul>

</div>
</body>