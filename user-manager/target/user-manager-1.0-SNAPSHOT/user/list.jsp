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
    <title>List User</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>

       .header a {
            position: relative;
            display: inline-block;
            font-family: "Great Vibes", serif;
           font-size: 2.9vw;
            text-decoration: none;
            color: rgb(102, 153, 255);
        }

      .header  a:hover::after {
            content: "";
            display: block;
            position: absolute;
            width: 100%;

            /* Adjust height and bottom values to work with selected font */
            height: .05em;
            bottom: .1em;

            /* Create gradient */
            background-image: linear-gradient(
                    to right,
                    transparent 0%,
                    rgba(102, 153, 255, .6) 30%,
                    rgba(102, 153, 255, .7) 50%,
                    rgba(102, 153, 255, .6) 70%,
                    transparent 100%
            );

            /* Set-up fade-in animation */
            opacity: 0;
            animation: fadeIn 400ms ease-out forwards;
        }

        /* Fade-in animation */
        @keyframes fadeIn {
            100% {
                opacity: 1;
            }
        }
    </style>

</head>
<body>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">User Management Binh Hu</h2>


            <h2>
                <div class="header">
                    <a href="/users?action=create">Create User Here</a>
                </div>


            </h2>
            <div style="display: flex; justify-content: center">
                <form method="get" >
                    <div class="input-group">
                        <div class="form-outline">
                            <input type="hidden" name="action" value="search"/>
                            <input id="search-input"  name="search" style="width: 30em;" placeholder="Search anything..."
                                   type="search" id="form1" class="form-control"/>

                        </div>
                        <button id="search-button"  style="height: fit-content; " type="submit" class="btn btn-primary">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </form>

                <form method="get">
                    <input type="hidden" name="action" value="sort">
                    <button style="float: right;margin-left: 6em;" type="submit"
                            class="btn btn-outline-secondary">Sort By Name</button>
                </form>
            </div>



    </div>
        <br><br>
    <div class="panel-body" style="text-align: center">
        <table class="table table-bordered">
            <thead >
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th >Edit</th>
                <th>Delete</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listUser}">
                <tr>

                    <td>${user.id}</td>
                    </td>
                    <td>${user.name}</td>
                    </td>
                    <td>${user.email}</td>
                    </td>
                    <td>${user.country}</td>
                    </td>


                    <td><a href="/users?action=edit&id=${user.id}">Edit</a></td>
                    <td><a href="/users?action=delete&id=${user.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</div>
</body>

</html>