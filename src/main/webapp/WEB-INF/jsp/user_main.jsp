<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<jsp:useBean id="findPc" scope="request" type="java.util.List"/>
&lt;%&ndash;Нет. Ты не сможешь победить силы Зла&ndash;%&gt;--%>
<%--"Твоя борьба против каши в JSP обречена на провал, Ха-ха-ха"--%>


<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>User Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style2.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css"/>
</head>
<body>

<div class="container">
    <h2>User Info</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <%--<div class="col col-1" data-label="Login"><c:out value="${sessionScope.user.login}"> default="NO DATA" escapeXml="true"</c:out></div>--%>
            <div class="col col-2" data-label="Name"><c:out value="${sessionScope.user.name}"> default="NO DATA" escapeXml="true"</c:out></div>
            <div class="col col-3" data-label="Surname"><c:out value="${sessionScope.user.surname}">default="NO DATA" escapeXml="true"</c:out></div>
            <div class="col col-4" data-label="Age"><c:out value="${sessionScope.user.age}">default="NO DATA" escapeXml="true"</c:out></div>
            <div class="col col-4" data-label="Address"><c:out value="${sessionScope.user.address}">default="NO DATA" escapeXml="true"</c:out></div>
            <div class="col col-4" data-label="Email"><c:out value="${sessionScope.user.email}">default="NO DATA" escapeXml="true"</c:out></div>
        </li>
    </ul>
    <table class="local-form" align="center">
        <tr>
            <th>
                <div class="local-form">
                    <form action="Controller" method="get">
                        <input type="hidden" name="command" value="sing_out"/>
                        <input type="submit" value="Show all PC config">
                    </form>
                </div>
            </th>
            <th>
            <th>
                <div class="local-form">
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="sing_out"/>
                        <input type="submit" value="Add new PC config">
                    </form>
                </div>
            </th>
            <th>
                <div>
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value=""/>
                        <input type="submit" value="Change Password">
                    </form>
                </div>
            </th>
            <th>
                <div>
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="sing_out"/>
                        <input type="submit" value="Sing Out">
                    </form>
                </div>
            </th>
        </tr>
    </table>


    <table class="main-form-style" align="center">
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>CPU</th>
            <th>MotherBoard</th>
            <th>Ram</th>
            <th>VGA</th>
        </tr>

        <c:forEach items="${requestScope.findPC}" var="pc">
            <tr align="center">
                <td>${pc.idPC}</td>
                <td>${pc.date}</td>
                <td>${pc.pcCPU}</td>
                <td>${pc.pcMb}</td>
                <td>${pc.pcRam}</td>
                <td>${pc.pcVga}</td>
                <td>
                <a href="Controller?command=info_user_pc&login=${sessionScope.user.login}&pcId=${pc.idPC}">
                        <p style="color: #1634ff;" align="center">Подробнее</p>
                    </a>
                </td>

                <td>
                    <a href="Controller?command=delete_user_pc&login=${sessionScope.user.login}&pcId=${pc.idPC}">
                        <p style="color: #FF0000;" align="center">Удалить</p>
                    </a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>