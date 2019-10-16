<%--
  Created by IntelliJ IDEA.
  User: vi
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="static/css/style.css"></link>

<div class="workingroom">
    <div class="errorInfo">${error}</div>
    <form action="login" method="post">
        <input type="text" placeholder="用户名" name="name" ><br>
        <input type="password" placeholder="密码" name="password"><br>
        <input type="submit">
    </form>
    <div>
        <span class="desc">用户名:zhang3,密码:12345,角色:admin</span><br>
        <span class="desc">用户名:li4,密码:abcde,角色:productManager</span>
    </div>
</div>