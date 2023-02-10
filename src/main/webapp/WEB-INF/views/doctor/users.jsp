<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Time</title>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/> "/>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="/css/user.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/table.css"/>
    <link rel="stylesheet" href="/css/tables.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="col-md-7">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand">It-Academy</a>
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
            <div class="userinfo">
                <div class="user">
                    <ul>
                        <li>
                            <c:if test="${userForm.userName!=null}">
                                <c:if test="${userForm.photo!=null}">
                                    <img src="${pageContext.request.contextPath}/image" title="user-name"/>
                                </c:if>
                                <c:if test="${userForm.photo==null}">
                                    <img src="../image/smail.jfif" title="user-name"/>
                                </c:if>
                                <span>Hello ${userForm.userName}</span>
                            </c:if>
                        </li>
                    </ul>
                </div>
            </div>
            <div>
            </div>
        </div>
    </nav>
</header>
<div class="container-fluid">
    <div>
        <button class="custom-btn btn-6">
                        <span>
                        <a href="">${localDate}</a>
                    </span>
        </button>
    </div>
    <div>
        <table>
            <tr>
                <th>Time</th>
                <th>Family</th>
                <th>Name</th>
                <th>Patronymic</th>
                <th>Date Birth</th>
                <th>Gender</th>
                <th>Address</th>
                <th>Contact Number</th>
                <th>Medical History</th>
            </tr>
                <c:forEach var="time" items="${currentDate}">
            <tr>
                    <td>${time.time}</td>
                    <td>${time.passport.family}</td>
                    <td>${time.passport.name}</td>
                    <td>${time.passport.patronymic}</td>
                    <td>${time.passport.dateBirth}</td>
                    <td>${time.passport.gender}</td>
                    <td>${time.passport.address}</td>
                    <td>${time.passport.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/doctor/users/medicalHistory?idPassport=${time.passport.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
            </tr>
                </c:forEach>
        </table>
    </div>
</div>
</body>
</html>