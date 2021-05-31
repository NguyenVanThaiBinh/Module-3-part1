<%@ page import="com.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
    Document   : add
    Created on : Aug 17, 2020, 8:22:48 PM
    Author     : Diep
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sort User</title>
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
            <h2 class="text-center">Sort Result</h2>




        </div>
        <br><br>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${sortUser}">
                    <tr>

                        <td>${user.id}</td></td>
                        <td>${user.name}</td></td>
                        <td>${user.email}</td></td>
                        <td>${user.country}</td></td>



                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br><br>
        <button class="btn btn-danger" style="float: left">
            <a href="users"style="color: white"> Back To List</a></button>

    </div>
</div>
</body>
</html>