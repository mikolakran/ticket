<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="col-md-8">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/loginS" class="navbar-brand">It-Academy</a>
                </div>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/login">Главная</a></li>
                    <li><a href="#">О нас</a></li>
                    <li><a href="#">Обратная связь</a></li>
                    <li><a href="${pageContext.request.contextPath}/addUser">Registration</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container">

    <form class="well form-horizontal" action="addUser" method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <center><h2><b>Registration Form</b></h2></center>
            </legend>
            <br>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="name" name="name" required="required" placeholder="Name" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Family</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="family" name="family" required="required" placeholder="Family" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Patronymic</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="patronymic" name="patronymic" required="required" placeholder="Patronymic"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Patronymic</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="address" name="address" required="required" placeholder="Address"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Date Birth</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="dateBirth" name="dateBirth" placeholder="Date Birth" class="form-control"
                               value="1930-01-01"
                               type="date">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Gender</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select id="gender" name="gender" class="form-control selectpicker">
                            <option>Men's</option>
                            <option>Womanish</option>
                        </select>
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">User Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="userName" name="userName" required="required" placeholder="Username"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="password" name="password" required="required" placeholder="Password"
                               class="form-control"
                               type="password">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Confirm Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="confirmPassword" name="confirmPassword" required="required"
                               placeholder="Confirm Password"
                               class="form-control" type="password">
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label">E-Mail</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input id="email" name="email" required="required" placeholder="E-Mail Address"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>


            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Contact No.</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                        <input id="contactNumber" name="contactNumber" placeholder="(639)" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <!-- Select Basic -->

            <!-- Success message -->
            <div class="alert alert-success" role="alert" id="success_message">Success <i
                    class="glyphicon glyphicon-thumbs-up"></i> Success!.
            </div>

            <!-- Button -->
            <%--            <div class="form-group">
                            <label class="col-md-4 control-label"></label>
                            <div class="col-md-4"><br>
                                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <button onclick="addUser()">Send request</button>
                                <button type="submit" class="btn btn-warning">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span
                                        class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                </button>
                            </div>
                        </div>--%>

        </fieldset>
    </form>
    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label"></label>
        <div class="col-md-4"><br>
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <button class="btn btn-warning" onclick="addUser()">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span
                    class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            </button>
        </div>
    </div>
</div>
</div><!-- /.container -->
<p id="paragraph"></p>
<script type="text/javascript">
    const restUrl = "addUser";

    function url(u) {
        return "<%=request.getContextPath()%>/" + u;
    }

    function addUser() {
        var name = $("#name").val()
        var family = $("#family").val()
        var patronymic = $("#patronymic").val()
        var dateBirth = $("#dateBirth").val()
        var address = $("#address").val()
        var gender = $("#gender").val()
        var contactNumber = $("#contactNumber").val()

        var nameUser = $("#userName").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        var email = $("#email").val();

        var myPassport = {
            name: name,
            family: family,
            patronymic: patronymic,
            dateBirth: dateBirth,
            address: address,
            gender: gender,
            contactNumber: contactNumber
        }
        var user = {
            userName: nameUser,
            password: password,
            confirmPassword: confirmPassword,
            email: email,
            passport:myPassport
        };
        $.ajax({
            url: url(restUrl),
            datatype: 'json',
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(user)
        }).done(function (data) {
            if (data) {
                if (data.error) {
                    $(".personTable").text(data.error);
                } else {
                    window.location.href = url("login");
                }
            }
        }).fail(function (data) {
            $(".personTable").text("error");
        });
    }
</script>
</body>
</html>