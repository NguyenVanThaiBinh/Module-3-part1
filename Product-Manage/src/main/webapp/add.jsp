<!DOCTYPE html>
<html>
<head>
    <title>Registation Form * Form Tutorial</title>
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
            <h2 class="text-center">Registation Form</h2>
        </div>
        <div class="panel-body">
            <form method="post" >
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" value="${index}" name="index" style="display: none;"/>
                    <input required="true" type="text" value="${product.name}"class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input required="true" type="email"value="${product.email}" class="form-control" id="email" name="email">
                </div>



                <button class="btn btn-success">Register</button>
            </form>
            <button class="btn btn-success" style="float: right">  <a href="list-form"style="color: white"> To List</a></button>

        </div>
    </div>
</div>
</body>
</html>