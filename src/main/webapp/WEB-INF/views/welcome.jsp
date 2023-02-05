<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
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
                                    <img src="${pageContext.request.contextPath}/image/smail.jfif" title="user-name"/>
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
    <div id="men-left" class="rad col-md-2"></div>
    <div class=" col-md-6">
        <div>
            <h1 id="h1r" class=" text-center">Welcome</h1>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <c:if test="${userForm.userName!=null}">
                    <h3 style="color: deepskyblue">Hello ${userForm.userName}</h3>
                </c:if>
                <button class="custom-btn btn-6">
                        <span>
                      <a href="${pageContext.request.contextPath}/admin/createDoctor">add Doctor</a>
                    </span>
                </button>
                <button class="custom-btn btn-6">
                        <span>
                      <a href="${pageContext.request.contextPath}/admin/findDoctor">add Calendar Doctor</a>
                    </span>
                </button>
                <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}/admin/createPositionDoctor">add Position
                    Doctor</a>
                    </span>
                </button>
                <button class="custom-btn btn-6">
                        <span>
                      <a href="${pageContext.request.contextPath}/admin/createCalendar">add in calendar</a>
                    </span>
                </button>
                <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/admin/users">Your users</a>
                    </span>
                </button>
                <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}/admin/doctors">Your doctors</a>
                    </span>
                </button>
                <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}/admin/positions">Your position Doctor</a>
                    </span>
                </button>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_USER')">
                <c:if test="${calendars.size()!=0}">
                    <h4 style="color: red">Для отмены записи звонить в регистратуру</h4>
            <table>
                <tr>
                    <th>Local Date</th>
                    <th>Time</th>
                    <th>Cabinet Number</th>
                    <th>Speciality Doctor</th>
                    <th>Family Doctor</th>
                    <th>Name Doctor</th>
                </tr>
                <c:forEach var="calendar" items="${calendars}">
                <tr>
                    <td>${calendar.localDate}</td>
                    <td>${calendar.nameTime}</td>
                    <td>${calendar.doctor.cabinetNumber}</td>
                    <td>${calendar.doctor.specialityDoctor}</td>
                    <td>${calendar.doctor.user.passport.family}</td>
                    <td>${calendar.doctor.user.passport.name}</td>
                </tr>
                </c:forEach>
            </table>
                </c:if>
                <c:if test="${calendars.size()==0}">
                <div class="content">
                    <c:forEach var="position" items="${positions}">
                        <div class="col-md-4">
                            <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}/doctorByPosition?idPosition=${position.positionDoctorId}"
                           >${position.position}</a>
                    </span>
                            </button>
                        </div>
                    </c:forEach>
                </div>
                </c:if>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_DOCTOR')">
            <c:forEach var="calendar" items="${calendarDoctors}">
                <div class="col-md-4">
                    <div class="cell three">
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/allUsers?idDate=${calendar.idDate}"
                         >${calendar.localDate}</a>
                    </span>
                        </button>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div>
            <c:if test="${pageMinus!=-1}">
                <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/welcome/${pageNo-1}?idDoctor=${idDoctor}"
                         >Назад</a>
                    </span>
                </button>
            </c:if>
            <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/welcome/${pageNo+1}?idDoctor=${idDoctor}"
                         >Далее</a>
                    </span>
            </button>
        </div>
            </security:authorize>
        </div>
    </div>
    <div class="col-md-1">
        <security:authorize access="hasRole('ROLE_USER')">
        <c:if test="${calendars.size()!=0}">
            <h4>Запись к врачу</h4>
            <div class="content">
                <c:forEach var="position" items="${positions}">
                    <div >
                        <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}/doctorByPosition?idPosition=${position.positionDoctorId}"
                        >${position.position}</a>
                    </span>
                        </button>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        </security:authorize>
    </div>
</div>

</body>
</html>