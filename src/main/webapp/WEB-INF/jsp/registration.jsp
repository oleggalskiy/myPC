<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css"/>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="locale.main.regpage.text" var="regpage"/>
</head>
<body>
<div class="main-form-style">
    <h2>Enter your info</h2>
    <form action="Controller" method="post">
        <input type="hidden" name="command" value="REGISTRATION"/>

        <input type="text" name="login" value="" placeholder="Login" />
        <input type="password" name="password"  value="" placeholder="Password" />
        <input type="text" name="First Name"  value="" placeholder="First name" />
        <input type="text" name="Second Name"  value="" placeholder="Second Name" />
        <input type="text" name="Age"  value="" placeholder="Age" />
        <input type="text" name="Address"  value=""placeholder="Address" />
        <input type="email" name="Email"  value="" placeholder="Email" />
        <input type="submit" value="<c:out value="${regpage}"/>">
    </form>

    <i>
        <c:if test="${not empty requestScope.errorMessage}">
            <c:out value="${requestScope.errorMessage}"/>
        </c:if>
    </i>
</div>
</body>
</html>
