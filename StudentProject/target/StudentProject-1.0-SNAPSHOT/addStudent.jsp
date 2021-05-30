<%--
    Document   : addStudent
    Created on : Aug 24, 2020, 7:39:48 PM
    Author     : Diep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <!-- Latest compiled and minified CSS -->
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
            <h2 class="text-center">Add Student</h2>
        </div>
        <div class="panel-body">
            <form method="post">
                <div class="form-group">
                    <label for="usr">Name:</label>
                    <input type="text" name="id" value="${std.id}" style="display: none;"/>
                    <input required="true" type="text" class="form-control" value="${std.fullname}" id="usr"
                           name="name"/>
                </div>
                <div class="form-group">
                    <label for="age">Age:</label>
                    <input required="true" type="number" class="form-control" value="${std.age}" id="age" name="age"/>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control" id="address" value="${std.address}" name="address"/>
                </div>
                <button class="btn btn-success">Register</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
