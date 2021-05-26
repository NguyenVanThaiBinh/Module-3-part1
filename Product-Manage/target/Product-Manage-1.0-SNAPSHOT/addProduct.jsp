<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/26/2021
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Form</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

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
            <h2 class="text-center">Add product Binh Hu</h2>
        </div>
        <div class="panel-body">
            <form  method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input required="true" type="text" class="form-control" id="name">
                </div>
                <div class="form-group">
                    <label for="category">Category:</label>
                    <input required="true" type="text" class="form-control" id="category">
                </div>
                <div class="form-group">
                    <label for="price">Price product:</label>
                    <input type="number" class="form-control" id="price">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input required="true" type="text" class="form-control" id="description">
                </div>

                <button class="btn btn-success">Register</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>
