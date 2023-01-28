<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Calendar</title>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/> "/>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/> "/>
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
    <div class="col-md-1"></div>
    <div class=" col-md-4">
        <div>
            <h1 id="h1r" class=" text-center">Calendar</h1>
            <c:forEach var="calendar" items="${calendarDoctors}">
                <div class="col-md-4">
                    <div class="cell three">
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/ticketTimes?idDate=${calendar.idDate}"
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
                         <a href="${pageContext.request.contextPath}/calendarTicket/${pageNo-1}?idDoctor=${idDoctor}"
                         >Назад</a>
                    </span>
                </button>
            </c:if>
            <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/calendarTicket/${pageNo+1}?idDoctor=${idDoctor}"
                         >Далее</a>
                    </span>
            </button>
        </div>
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>
</div>
</body>
</html>