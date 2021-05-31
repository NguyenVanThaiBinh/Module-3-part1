<!DOCTYPE html>
<html>
<head>
    <title>Create User</title>
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
            <h2 class="text-center">Create User</h2>

            <%String addMsg = (String) request.getAttribute("addMsg");%>

            <br>
            <c:if test="${addMsg != null}">
                <h3 style="color: blue"><%=addMsg%></h3>
            </c:if>


        </div>
        <div class="panel-body">
            <form method="post" >
                <div class="form-group">
                    <label for="name">Name:</label>

                    <input required="true" type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input required="true" type="email"class="form-control" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="country">Country:</label>
                    <input required="true" type="text"class="form-control" id="country" name="country">
                </div>



                <button class="btn btn-success">Add new</button>

            </form>
            <br><br>
            <button class="btn btn-danger" style="float: left">
                <a href="users"style="color: white"> Back To List</a></button>


        </div>
    </div>
</div>
</body>
</html>