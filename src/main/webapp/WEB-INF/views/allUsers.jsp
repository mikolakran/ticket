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
    <div>
        <button class="custom-btn btn-6">
                        <span>
                        <a href="">${currentDate}</a>
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
            <tr>
                <td>time 8-30</td>
                <c:if test="${time8_30!=null}">
                    <td>${time8_30.family}</td>
                    <td>${time8_30.name}</td>
                    <td>${time8_30.patronymic}</td>
                    <td>${time8_30.dateBirth}</td>
                    <td>${time8_30.gender}</td>
                    <td>${time8_30.address}</td>
                    <td>${time8_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time8_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time8_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 9-00</td>
                <c:if test="${time9_00!=null}">
                    <td>${time9_00.family}</td>
                    <td>${time9_00.name}</td>
                    <td>${time9_00.patronymic}</td>
                    <td>${time9_00.dateBirth}</td>
                    <td>${time9_00.gender}</td>
                    <td>${time9_00.address}</td>
                    <td>${time9_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time9_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time9_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 9-30</td>
                <c:if test="${time9_30!=null}">
                    <td>${time9_30.family}</td>
                    <td>${time9_30.name}</td>
                    <td>${time9_30.patronymic}</td>
                    <td>${time9_30.dateBirth}</td>
                    <td>${time9_30.gender}</td>
                    <td>${time9_30.address}</td>
                    <td>${time9_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time9_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time9_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 10-00</td>
                <c:if test="${time10_00!=null}">
                    <td>${time10_00.family}</td>
                    <td>${time10_00.name}</td>
                    <td>${time10_00.patronymic}</td>
                    <td>${time10_00.dateBirth}</td>
                    <td>${time10_00.gender}</td>
                    <td>${time10_00.address}</td>
                    <td>${time10_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time10_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time10_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 10-30</td>
                <c:if test="${time10_30!=null}">
                    <td>${time10_30.family}</td>
                    <td>${time10_30.name}</td>
                    <td>${time10_30.patronymic}</td>
                    <td>${time10_30.dateBirth}</td>
                    <td>${time10_30.gender}</td>
                    <td>${time10_30.address}</td>
                    <td>${time10_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time10_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time10_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 11-00</td>
                <c:if test="${time11_00!=null}">
                    <td>${time11_00.family}</td>
                    <td>${time11_00.name}</td>
                    <td>${time11_00.patronymic}</td>
                    <td>${time11_00.dateBirth}</td>
                    <td>${time11_00.gender}</td>
                    <td>${time11_00.address}</td>
                    <td>${time11_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time11_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time11_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 11-30</td>
                <c:if test="${time11_30!=null}">
                    <td>${time11_30.family}</td>
                    <td>${time11_30.name}</td>
                    <td>${time11_30.patronymic}</td>
                    <td>${time11_30.dateBirth}</td>
                    <td>${time11_30.gender}</td>
                    <td>${time11_30.address}</td>
                    <td>${time11_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time11_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time11_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 13-00</td>
                <c:if test="${time13_00!=null}">
                    <td>${time13_00.family}</td>
                    <td>${time13_00.name}</td>
                    <td>${time13_00.patronymic}</td>
                    <td>${time13_00.dateBirth}</td>
                    <td>${time13_00.gender}</td>
                    <td>${time13_00.address}</td>
                    <td>${time13_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time13_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time13_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 13-30</td>
                <c:if test="${time13_30!=null}">
                    <td>${time13_30.family}</td>
                    <td>${time13_30.name}</td>
                    <td>${time13_30.patronymic}</td>
                    <td>${time13_30.dateBirth}</td>
                    <td>${time13_30.gender}</td>
                    <td>${time13_30.address}</td>
                    <td>${time13_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time13_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time13_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 14-00</td>
                <c:if test="${time14_00!=null}">
                    <td>${time14_00.family}</td>
                    <td>${time14_00.name}</td>
                    <td>${time14_00.patronymic}</td>
                    <td>${time14_00.dateBirth}</td>
                    <td>${time14_00.gender}</td>
                    <td>${time14_00.address}</td>
                    <td>${time14_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time14_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time14_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 14-30</td>
                <c:if test="${time14_30!=null}">
                    <td>${time14_30.family}</td>
                    <td>${time14_30.name}</td>
                    <td>${time14_30.patronymic}</td>
                    <td>${time14_30.dateBirth}</td>
                    <td>${time14_30.gender}</td>
                    <td>${time14_30.address}</td>
                    <td>${time14_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time14_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time14_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 15-00</td>
                <c:if test="${time15_00!=null}">
                    <td>${time15_00.family}</td>
                    <td>${time15_00.name}</td>
                    <td>${time15_00.patronymic}</td>
                    <td>${time15_00.dateBirth}</td>
                    <td>${time15_00.gender}</td>
                    <td>${time15_00.address}</td>
                    <td>${time15_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time15_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time15_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 15-30</td>
                <c:if test="${time15_30!=null}">
                    <td>${time15_30.family}</td>
                    <td>${time15_30.name}</td>
                    <td>${time15_30.patronymic}</td>
                    <td>${time15_30.dateBirth}</td>
                    <td>${time15_30.gender}</td>
                    <td>${time15_30.address}</td>
                    <td>${time15_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time15_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time15_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 16-00</td>
                <c:if test="${time16_00!=null}">
                    <td>${time16_00.family}</td>
                    <td>${time16_00.name}</td>
                    <td>${time16_00.patronymic}</td>
                    <td>${time16_00.dateBirth}</td>
                    <td>${time16_00.gender}</td>
                    <td>${time16_00.address}</td>
                    <td>${time16_00.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time16_00.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time16_00==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
            <tr>
                <td>time 16-30</td>
                <c:if test="${time16_30!=null}">
                    <td>${time16_30.family}</td>
                    <td>${time16_30.name}</td>
                    <td>${time16_30.patronymic}</td>
                    <td>${time16_30.dateBirth}</td>
                    <td>${time16_30.gender}</td>
                    <td>${time16_30.address}</td>
                    <td>${time16_30.contactNumber}</td>
                    <td>
                        <button class="custom-btn btn-6">
                        <span>
                         <a href="${pageContext.request.contextPath}/medicalHistory?idPassport=${time16_30.idPassport}">
                             Medical History</a>
                    </span>
                        </button>
                    </td>
                </c:if>
                <c:if test="${time16_30==null}">
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </c:if>
            </tr>
        </table>
    </div>
</div>
</body>
</html>