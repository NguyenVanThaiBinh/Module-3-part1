<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/25/2021
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Product: <%= request.getAttribute("product")%></p>
    <p>Price: <%= request.getAttribute("price")%></p>
    <p>Discount: <%= request.getAttribute("discount")%></p>
    <p>Amount: <%= request.getAttribute("amount")%></p>
    <p>Total: <%= request.getAttribute("total")%></p>

</body>
</html>
