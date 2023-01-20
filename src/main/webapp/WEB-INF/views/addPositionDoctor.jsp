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
                    <a href="${pageContext.request.contextPath}/home" class="navbar-brand">It-Academy</a>
                </div>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/home">Главная</a></li>
                    <li><a href="#">О нас</a></li>
                    <li><a href="#">Обратная связь</a></li>
                    <li><a href="${pageContext.request.contextPath}/addUser">Registration</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container">

    <form class="well form-horizontal" action="addPositionDoctor" method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <center><h2><b>Add Position Doctor</b></h2></center>
            </legend>
            <br>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Position Doctor</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="position" name="position" required="required" placeholder="Position Doctor" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Beginning Work</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="beginningWork" name="beginningWork" required="required" placeholder="format 00:00" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">End Work</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="endWork" name="endWork" required="required" placeholder="format 00:00"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Beginning Break</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="beginningBreak" name="beginningBreak" required="required" placeholder="format 00:00"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">End Break</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="endBreak" name="endBreak" required="required" placeholder="format 00:00"
                               class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

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
    const restUrl = "addPositionDoctor";

    function url(u) {
        return "<%=request.getContextPath()%>/" + u;
    }

    function addUser() {
        var position = $("#position").val()
        var beginningWork = $("#beginningWork").val()
        var endWork = $("#endWork").val()
        var beginningBreak = $("#beginningBreak").val()
        var endBreak = $("#endBreak").val()

        var positionDoctor = {
            position: position,
            beginningWork: beginningWork,
            endWork: endWork,
            beginningBreak: beginningBreak,
            endBreak: endBreak
        };
        $.ajax({
            url: url(restUrl),
            datatype: 'json',
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(positionDoctor)
        }).done(function (data) {
            if (data) {
                if (data.error) {
                    $(".personTable").text(data.error);
                } else {
                    window.location.href = url("welcome");
                }
            }
        }).fail(function (data) {
            $(".personTable").text("error");
        });
    }
</script>
</body>
</html>