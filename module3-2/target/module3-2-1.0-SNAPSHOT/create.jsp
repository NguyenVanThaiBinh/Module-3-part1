<!DOCTYPE html>
<html>
<head>
    <title>Create </title>
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
            <h2 class="text-center">Create Staff</h2>

            <%String addMsg = (String) request.getAttribute("addMsg");%>

            <br>
            <c:if test="${addMsg != null}">
                <h3 style="color: blue"><%=addMsg%>
                </h3>
            </c:if>


        </div>
        <div class="panel-body">
            <form method="post" id="carform">
                <div class="form-group">

                    <label for="cars">Group Staff:</label>
                    <select class="custom-select custom-select-lg mb-2" name="group" id="cars" form="carform">
                        <option value="Nhan Vien">Nhan Vien</option>
                        <option value="Le Tan">Le Tan</option>
                        <option value="Quan Ly">Quan Ly</option>
                        <option value="Lao Cong">Lao Cong</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>

                    <input required="true" type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="dob">Day of Birth:</label>

                    <input required="true" type="datetime-local" class="form-control" id="dob" name="dob">

                </div>
                <br>
                <div class="form-group">

                        <p>Please select your gender:</p>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio"  value="Female" id="customRadioInline1" name="gender" class="custom-control-input">
                        <label class="custom-control-label" for="customRadioInline1">Female</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" value="Male" id="customRadioInline2" name="gender" class="custom-control-input">
                        <label class="custom-control-label" for="customRadioInline2">Male</label>
                    </div>





                </div>

                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input pattern="[0-9]{3}[0-9]{3}[0-9]{4}" required="true" type="text"
                           class="form-control" id="phone" name="phone">
                    <small>Format: 0234567890</small>
                </div>
                <div class="form-group">
                    <label for="cmnd">CMND:</label>
                    <input required="true" type="number" class="form-control" id="cmnd" name="cmnd">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input required="true" type="text" class="form-control" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input required="true" type="text" class="form-control" id="address" name="address">
                </div>


                <button class="btn btn-success">Add new</button>

            </form>
            <br><br>
            <button class="btn btn-danger" style="float: left">
                <a href="staff" style="color: white"> Back To List</a></button>


        </div>
    </div>
</div>
</body>
</html>