<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket Time</title>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/> "/>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="/css/user.css"/>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/table.css" />
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
                                    <img src="image/smail.jfif" title="user-name"/>
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
            <h1 id="h1r" class=" text-center">Ticket Time</h1>
            <c:if test="${doctorsNull!=null}">
                <h3 class="text-center">${doctorsNull}</h3>
            </c:if>
            <c:if test="${doctorsNull==null}">
                <h2 class="text-center">Ticket</h2>
            </c:if>
                <c:if test="${calendarTime.time8_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}
                        /confirmTime?idDate=${calendarTime.idDate}&time=time8_30 ">8-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time9_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                       <a href="${pageContext.request.contextPath}
                       /confirmTime?idDate=${calendarTime.idDate}&time=time9_00 ">9-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time9_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                       <a href="${pageContext.request.contextPath}
                       /confirmTime?idDate=${calendarTime.idDate}&time=time9_30 ">9-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time10_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                      <a href="${pageContext.request.contextPath}
                      /confirmTime?idDate=${calendarTime.idDate}&time=time10_00 ">10-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time10_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                       <a href="${pageContext.request.contextPath}
                       /confirmTime?idDate=${calendarTime.idDate}&time=time10_30 ">10-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time11_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                        <a href="${pageContext.request.contextPath}
                        /confirmTime?idDate=${calendarTime.idDate}&time=time11_00 ">11-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time11_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}
                         /confirmTime?idDate=${calendarTime.idDate}&time=time11_30 ">11-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time13_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}
                         /confirmTime?idDate=${calendarTime.idDate}&time=time13_00 ">13-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time13_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                          <a href="${pageContext.request.contextPath}
                          /confirmTime?idDate=${calendarTime.idDate}&time=time13_30 ">13-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time14_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                          <a href="${pageContext.request.contextPath}
                          /confirmTime?idDate=${calendarTime.idDate}&time=time14_00 ">14-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time14_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}
                         /confirmTime?idDate=${calendarTime.idDate}&time=time14_30 ">14-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time15_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                     <a href="${pageContext.request.contextPath}
                     /confirmTime?idDate=${calendarTime.idDate}&time=time15_00 ">15-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time15_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                     <a href="${pageContext.request.contextPath}
                     /confirmTime?idDate=${calendarTime.idDate}&time=time15_30 ">15-30</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time16_00==0}">
                    <button class="custom-btn btn-6">
                        <span>
                   <a href="${pageContext.request.contextPath}
                   /confirmTime?idDate=${calendarTime.idDate}&time=time16_00 ">16-00</a>
                    </span>
                    </button>
                </c:if>
                <c:if test="${calendarTime.time16_30==0}">
                    <button class="custom-btn btn-6">
                        <span>
                  <a href="${pageContext.request.contextPath}
                  /confirmTime?idDate=${calendarTime.idDate}&time=time16_30 ">16-30</a>
                    </span>
                    </button>
                </c:if>
        </div>
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>
</div>
</body>
</html>