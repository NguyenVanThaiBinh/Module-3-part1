<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/26/2021
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Student List JSP</title>
    <style>


        table {
           margin: 0em 4em;
        }
    </style>
</head>
<body>
<h1>Student List JSP</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">No</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Birthday</th>
        <th scope="col">Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${studentList}" varStatus="index">
        <tr>
            <td>${index.index}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.birthday}</td>
            <td>${item.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
