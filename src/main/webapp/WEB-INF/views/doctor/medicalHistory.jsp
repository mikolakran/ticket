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
    <div class=" col-md-6">
        <div>
            <h1 id="h1r" class=" text-center">Medical History</h1>
            <security:authorize access="hasRole('ROLE_DOCTOR')">
                <c:if test="${medicalHistory.size()!=0}">
                    <table>
                        <tr>
                            <th>Дата</th>
                            <th>Основное заболевание </th>
                            <th>Осложнения</th>
                            <th>Сопутствующие заболевания </th>
                        </tr>
                        <c:forEach var="history" items="${medicalHistory}">
                            <tr>
                                <td>${history.localDate}</td>
                                <td>${history.underlyingDisease}</td>
                                <td>${history.complications}</td>
                                <td>${history.accompanyingIllnesses}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </security:authorize>
        </div>
    </div>
    <div class="col-md-1">
        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/doctor/users/medicalHistory/addMedicalHistory?idPassport=${idPassport}">
                             Add Medical History</a>
                    </span>
        </button>
    </div>
</div>

</body>
</html>