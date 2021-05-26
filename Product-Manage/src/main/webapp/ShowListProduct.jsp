<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/26/2021
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List Binh Hu</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">


</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">List product Binh Hu</h2>
        </div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <td>STT</td>
                    <td>Name</td>
                    <td>Category</td>
                    <td>Price</td>
                    <td>Description</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}" varStatus="loop">
                    <tr>
                        <td>${loop.index +1}</td>
                        <td>${product.name()}</td>
                        <td>${product.category}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                    </tr>

                </c:forEach>

                </tbody>

            </table>

        </div>
    </div>
</div>
</body>
</html>
