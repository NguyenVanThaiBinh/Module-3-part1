<%--
    Document   : add
    Created on : Aug 17, 2020, 8:22:48 PM
    Author     : Diep
--%>

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
            <h2 class="text-center">Add Product</h2>
        </div>
        <div class="panel-body">
            <form method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" value="${index}" name="index" style="display: none;"/>
                    <input required="true" value="${product.name}" type="text" class="form-control" id="name" name="name"/>
                </div>
                <div class="form-group">
                    <label for="category">Category:</label>
                    <input required="true" value="${product.category}" type="text" class="form-control" id="category" name="category"/>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" value="${product.price}" class="form-control" id="price" name="price"/>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" value="${product.description}" class="form-control" id="description" name="description"/>
                </div>
                <button class="btn btn-success">Register</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>