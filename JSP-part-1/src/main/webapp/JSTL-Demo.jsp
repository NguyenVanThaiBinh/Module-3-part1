<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/26/2021
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL DEMO</title>
</head>
<body>
    <c:set var="t" value="13" scope="request"></c:set>
<h2>Su dung bien T : ${t}</h2>
</body>
</html>
