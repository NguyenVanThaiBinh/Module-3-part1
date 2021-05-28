<%--
    Document   : add
    Created on : Aug 17, 2020, 8:22:48 PM
    Author     : Diep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">List Product</h2>
        </div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${product.name}</td>
                        <td>${product.category}</td>
                        <td>${product.price}</td>
                        <td>${product.description}</td>
                        <td>
                            <a href="add?id=${loop.index}">
                                <button class="btn btn-warning">Edit</button>
                            </a>
                        </td>
                        <td>
                            <form method="post">
                                <input name="index" value="${loop.index}" style="display: none"/>
                                <button class="btn btn-danger" name="action" value="delete">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>