<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/27/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    String sessionName =(String) request.getSession().getAttribute("name");
    System.out.println(sessionName);
%>
<h1>Welcome!!! <b><%= sessionName %></b></h1>
<h2><a href="lich-su-dang-ky-tai-khoan">History Register</a></h2>
</body>
</html>
