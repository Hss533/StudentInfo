<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/3/17
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理系统</title>
    <%
        System.out.println(session.getAttribute("currentUser"));
        if(session.getAttribute("currentUser")==null)
        {
            System.out.println("第一次登录");
            response.sendRedirect("index.jsp");
            return;
        }
    %>
</head>
<body>
    <div>欢迎您，学生信息管理系统</div>
    <div>当前用户${currentUser.userName}</div>
    <a href="gradeInfoManager.jsp">班级管理系统</a>
</body>
</html>
