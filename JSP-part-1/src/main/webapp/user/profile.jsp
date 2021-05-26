<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/26/2021
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello Binh Hu</h1>
<% int id = Integer.parseInt(request.getParameter("id"));%>
<p>Your ID is:  <%=id%></p>
<a href="logout.jsp">Log out</a>
</body>
</html>
