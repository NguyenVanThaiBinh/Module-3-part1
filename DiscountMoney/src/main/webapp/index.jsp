<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="discount" method="get">
    <label>Product Description
        <input type="text" name="product">
    </label>
    <label>List Price
        <input type="text" name="price">
    </label>
    <label>Discount Percent
        <input type="text" name="discount">
    </label>
    <input type="submit" id="submit" value="Calculate Discount">

</form>
</body>
</html>