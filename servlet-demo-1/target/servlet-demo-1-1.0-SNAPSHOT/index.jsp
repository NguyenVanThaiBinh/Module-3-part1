<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="add-user" method="post">
    <label>Name:
        <input type="text" name="name">
    </label>
    <label>Age:
        <input type="text" name="age">
    </label>
    <label>Address:
        <input type="text" name="address">
    </label>
    <input type="submit" value="submit">
</form>
<a href="/demoJSP.jsp">Hello Servlet</a>
</body>
</html>