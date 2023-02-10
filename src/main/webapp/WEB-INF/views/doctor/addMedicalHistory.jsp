<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Position Doctor</title>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/css/user.css"/>
    <link rel="stylesheet" href="/css/table.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="col-md-7">
                <div class="navbar-header">
                    <a href="${pageContext.request.contextPath}/home" class="navbar-brand">It-Academy</a>
                </div>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}/welcome/${0}">welcome</a>
                    </span>
                    </button>
                    <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/logout">logout</a>
                    </span>
                    </button>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container">

    <form class="well form-horizontal" action="addMedicalHistory" method="post" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <center><h2><b>Add Medical History</b></h2></center>
            </legend>
            <br>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Основное заболевание</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="underlyingDisease" name="underlyingDisease" required="required"
                               placeholder="Основное заболевание" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Осложнения</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="complications" name="complications" required="required"
                               placeholder="Осложнения" class="form-control"
                               type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Сопутствующие заболевания</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="accompanyingIllnesses" name="accompanyingIllnesses" required="required"
                               placeholder="Сопутствующие заболевания" class="form-control"
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
    const restUrl = "doctor/users/medicalHistory/addMedicalHistory";

    function url(u) {
        return "<%=request.getContextPath()%>/" + u+"?idPassport=${idPassport}";
    }

    function addUser() {
        var underlyingDisease = $("#underlyingDisease").val()
        var complications = $("#complications").val()
        var accompanyingIllnesses = $("#accompanyingIllnesses").val()

        var medicalHistory = {
            underlyingDisease: underlyingDisease,
            complications: complications,
            accompanyingIllnesses: accompanyingIllnesses
        };
        $.ajax({
            url: url(restUrl),
            datatype: 'json',
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(medicalHistory)
        }).done(function (data) {
            if (data) {
                if (data.error) {
                    $(".personTable").text(data.error);
                } else {
                    window.location.href = url("welcome/${0}");
                }
            }
        }).fail(function (data) {
            $(".personTable").text("error");
        });
    }
</script>
</body>
</html>