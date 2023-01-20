
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
    <link rel="stylesheet" href="/css/user.css" />
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
                    <li><a href="#">О нас</a></li>
                    <li><a href="#">Обратная связь</a></li>
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
            <p>${home}</p>
            <h1 id="h1r" class=" text-center">Welcome</h1>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <c:if test="${topicNull!=null}">
                    <h3 class="text-center">${topicNull}</h3>
                </c:if>
                <c:if test="${topicNull==null}">
                    <h2 class="text-center">All Topic</h2>
                </c:if>
                <c:if test="${userForm.userName!=null}">
                    <h3 style="color: deepskyblue">Hello ${userForm.userName}</h3>
                </c:if>
                <c:forEach var="position" items="${positions}">
                    <ul>
                        <li>${position.position}
                    </ul>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/addPositionDoctor" class="btn btn-primary">add Position Doctor</a>
                <a href="${pageContext.request.contextPath}/addDoctor" class="btn btn-primary">add Doctor</a>
                <a href="${pageContext.request.contextPath}/upDateUser" class="btn btn-primary">Update user</a>
                <a href="${pageContext.request.contextPath}/users" class="btn btn-primary">Your users</a>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">logout</a>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_USER')">
                <c:if test="${positionNull!=null}">
                    <h3 class="text-center">${positionNull}</h3>
                </c:if>
                <c:if test="${positionNull==null}">
                    <h2 class="text-center">All Topic</h2>
                </c:if>
                <c:forEach var="position" items="${positions}">
                    <ul>
                        <li>${position.position}
                            <a href="${pageContext.request.contextPath}/doctors?idPosition=${position.positionDoctorId}"
                               class="btn btn-primary"> Display Topic</a>
                        </li>
                    </ul>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/addTopic" class="btn btn-primary">Add Topic</a>
                <a href="${pageContext.request.contextPath}/upDateUser" class="btn btn-primary">Update user</a>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">logout</a>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_DOCTOR')">
                <c:if test="${topicNull!=null}">
                    <h3 class="text-center">${topicNull}</h3>
                </c:if>
                <c:if test="${topicNull==null}">
                    <h2 class="text-center">All Topic</h2>
                </c:if>
                <c:forEach var="topic" items="${topics}">
                    <ul>
                        <li>${topic.nameTopic}
                            <a href="${pageContext.request.contextPath}/posts?idTopic=${topic.id}"
                               class="btn btn-primary"> Display Topic</a>
                            <a href="${pageContext.request.contextPath}/welcome?deleteIdTopic=${topic.id}"
                               class="btn btn-primary"> Delete Topic</a>
                        </li>
                    </ul>
                </c:forEach>
                <a href="${pageContext.request.contextPath}/addTopic" class="btn btn-primary">Add Topic</a>
                <a href="${pageContext.request.contextPath}/upDateUser" class="btn btn-primary">Update user</a>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">logout</a>
            </security:authorize>
        </div>
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>
</div>

</body>
</html>