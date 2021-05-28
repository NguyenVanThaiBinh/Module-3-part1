<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/27/2021
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List Form </title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css/">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js/"></script>

    <!-- Popper JS -->
    <script></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js/"></script>
</head>
<body>
<% List<User> userList = null;

    if(session.getAttribute("userList") !=null){
        userList =(List<User>) session.getAttribute("userList");
    }else {
        userList = new ArrayList<>();
    }
%>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">History Form Binh Hu</h2>

        </div>
        <div class="panel-body">
          <table class="table table-bordered">
              <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Birthday</th>
                    <th>Address</th>
                </tr>
              </thead>
              <tbody>
                <%  int index = 1;
                    for (User user:userList) { %>
                <tr>
                    <td><%=index++ %></td>
                    <td><%= user.getName()%></td>
                    <td><%= user.getEmail()%></td>
                    <td><%= user.getBirthday()%></td>
                    <td><%= user.getAddress()%></td>
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
