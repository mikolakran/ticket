<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="c" %>
<%@ taglib prefix="fmt"
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Doctors</title>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/> "/>
    <link rel="stylesheet"
          href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/> "/>
    <link rel="stylesheet" href="/css/user.css"/>
</head>
<body>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="col-md-8">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand">It-Academy</a>
                </div>
            </div>
            <div>
                <ul class="nav navbar-nav">
<%--                    <li><a href="${pageContext.request.contextPath}/addPost?idTopic=${postForm.idTopic}">add
                        post</a></li>--%>
                    <li><a href="${pageContext.request.contextPath}/welcome">welcome</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">logout</a></li>
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
    <div class="col-md-2"></div>
    <div class=" col-md-4">
        <div>
            <h1 id="h1r" class=" text-center">Your posts</h1>
            <c:if test="${doctorsNull!=null}">
                <h3 class="text-center">${doctorsNull}</h3>
            </c:if>
            <c:if test="${doctorsNull==null}">
                <h2 class="text-center">All Doctors</h2>
            </c:if>
            <c:forEach var="doctor" items="${doctors}">
                <ul>
                    <li>Doctor : ${doctor.user.passport.name} ${doctor.user.passport.family}
                            ${doctor.user.passport.patronymic} cabinet number : ${doctor.cabinetNumber} speciality
                        doctor : ${doctor.specialityDoctor}</li>
                        <%--               <a href="${pageContext.request.contextPath}/updatePost?idTopic=${postForm.idTopic}&idPost=${doctor.idDoctor}"
                                          class="btn btn-primary"> Update</a>
                                       <a href="${pageContext.request.contextPath}/posts?deletePost=${doctor.id}&idTopic=${postForm.idTopic}"
                                          class="btn btn-primary"> Delete</a>--%>
                </ul>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>
</div>
</body>
</html>