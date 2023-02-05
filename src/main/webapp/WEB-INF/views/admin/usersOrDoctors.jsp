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
        <table>
            <c:if test="${users!=null}">
                <tr>
                    <th>User Name</th>
                    <th>Email</th>
                    <th>Family</th>
                    <th>Name</th>
                    <th>Patronymic</th>
                    <th>Date Birth</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Contact Number</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userName}</td>
                        <td>${user.email}</td>
                        <td>${user.passport.family}</td>
                        <td>${user.passport.name}</td>
                        <td>${user.passport.patronymic}</td>
                        <td>${user.passport.dateBirth}</td>
                        <td>${user.passport.gender}</td>
                        <td>${user.passport.address}</td>
                        <td>${user.passport.contactNumber}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${doctors!=null}">
                <tr>
                    <th>User Name</th>
                    <th>Email</th>
                    <th>Family</th>
                    <th>Name</th>
                    <th>Patronymic</th>
                    <th>Date Birth</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Contact Number</th>
                    <th>Cabinet Number</th>
                    <th>Speciality Doctor</th>
                </tr>
                <c:forEach var="doctor" items="${doctors}">
                    <tr>
                        <td>${doctor.userName}</td>
                        <td>${doctor.email}</td>
                        <td>${doctor.passport.family}</td>
                        <td>${doctor.passport.name}</td>
                        <td>${doctor.passport.patronymic}</td>
                        <td>${doctor.passport.dateBirth}</td>
                        <td>${doctor.passport.gender}</td>
                        <td>${doctor.passport.address}</td>
                        <td>${doctor.passport.contactNumber}</td>
                        <td>${doctor.doctor.cabinetNumber}</td>
                        <td>${doctor.doctor.specialityDoctor}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${positions!=null}">
                <tr>
                    <th>Position Doctor</th>
                    <th>Beginning Work</th>
                    <th>end Work</th>
                    <th>Beginning Break</th>
                    <th>End Break</th>
                </tr>
                <c:forEach var="position" items="${positions}">
                    <tr>
                        <td>${position.position}</td>
                        <td>${position.beginningWork}</td>
                        <td>${position.endWork}</td>
                        <td>${position.beginningBreak}</td>
                        <td>${position.endBreak}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${doctor!=null}">
                <tr>
                    <th>add calendar</th>
                    <th>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/admin/doctor/addCalendar">add calendar</a>
                    </span>
                        </button>
                    </th>
                </tr>
                <tr>
                    <th>User Name</th>
                    <th>Email</th>
                    <th>Family</th>
                    <th>Name</th>
                    <th>Patronymic</th>
                    <th>Date Birth</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>Contact Number</th>
                    <th>Cabinet Number</th>
                    <th>Speciality Doctor</th>
                </tr>
                <tr>
                    <td>${doctor.user.userName}</td>
                    <td>${doctor.user.email}</td>
                    <td>${doctor.user.passport.family}</td>
                    <td>${doctor.user.passport.name}</td>
                    <td>${doctor.user.passport.patronymic}</td>
                    <td>${doctor.user.passport.dateBirth}</td>
                    <td>${doctor.user.passport.gender}</td>
                    <td>${doctor.user.passport.address}</td>
                    <td>${doctor.user.passport.contactNumber}</td>
                    <td>${doctor.cabinetNumber}</td>
                    <td>${doctor.specialityDoctor}</td>
                </tr>
            </c:if>
        </table>
    </div>
</div>
</body>
</html>