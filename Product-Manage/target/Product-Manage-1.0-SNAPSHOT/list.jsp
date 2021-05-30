<%@ page import="com.Product_Manage.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
    Document   : add
    Created on : Aug 17, 2020, 8:22:48 PM
    Author     : Diep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
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
<% List<Product> productList = null;
    if (session.getAttribute("productList") != null) {
        productList = (List<Product>) session.getAttribute("productList");
    } else {
        productList = new ArrayList<>();
    }
%>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">List Product</h2>
        </div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th></th>
                    <th></th>

                </tr>
                </thead>
                <tbody>
                <% int index = -1;
                    for (Product user : productList) { %>
                <tr>
                    <td><%=++index%></td>
                    <td><%= user.getName()%>
                    </td>
                    <td><%= user.getEmail()%>
                    </td>
                    <td>
                        <a href="add-form?id=<%=index%>">
                            <button class="btn btn-warning">Edit</button>
                        </a>
                    </td>
                    <td>
                        <form method="post">
                            <input name="index" value="<%=index%>" style="display: none"/>
                            <button class="btn btn-danger" name="action" value="delete">Delete</button>
                        </form>
                    </td>

                </tr>
                <%
                    }%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>