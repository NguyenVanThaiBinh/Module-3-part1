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
<h2>c:out example</h2>
<c:set var="number" value="3"/>

<c:out value="${'This	is	true:	10	>	1	'}"	/>
<br/>
Tag:	<c:out value="${number}"/>
</body>
</html>