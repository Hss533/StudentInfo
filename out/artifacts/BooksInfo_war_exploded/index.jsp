<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/3/17
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>胡白白学生信息管理</title>
  </head>
  <body>
  <div class="main">
    <div>
        <h1 style="text-align: center" >
          用户登录
        </h1>
    </div>
    <div style="text-align: center">
        <form method="post" action="Login">
            用户名            <input type="text" id="username" name="username" value="${username}"/><br><br>
            密&nbsp;&nbsp;码  <input type="password" id="password" name="password" value="${password}"><br>
            <input type="button" value="重置">
            <input type="submit" value="提交">
            <p style="color: red;">${error}</p>
        </form>
    </div>
  </div>
  </body>
</html>
