<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" type="text/css"/>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="locale.main.login.text" var="login"/>
    <fmt:message bundle="${loc}" key="locale.main.password.text" var="password"/>
    <fmt:message bundle="${loc}" key="locale.main.signin.text" var="signin"/>
    <fmt:message bundle="${loc}" key="locale.main.regpage.text" var="regpage"/>
    <fmt:message bundle="${loc}" key="locale.main.titlelog.text" var="titlelog"/>
    <fmt:message bundle="${loc}" key="locale.main.maintitle.text" var="maintitle"/>
    <fmt:message bundle="${loc}" key="locale.main.maintext.text" var="maintext"/>

</head>
<body>

<div class="pagewrap">
    <div class="header-panel">
        <div class="local-form" style="width: 75px">
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="localization"/>
                <input type="submit" name="local" value="en"/>
                <input type="submit" name="local" value="ru"/>
            </form>
        </div>
        <div class="logomain">
            <img src="${pageContext.request.contextPath}/static/images/logo.jpg" border="0">
        </div>
        <div><h2 align="center"><c:out value="${maintitle}"/></h2>
            <div><p style="font-size: 28px"><c:out value="${maintext}"/></p></div>
        </div>
        <div class="login-panel">
            <div class="main-form-style">
                <div><h2><c:out value="${titlelog}"/></h2></div>
                <div>
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="sign_in"/>
                        <b><c:out value="${login}"/></b>
                        <input type="text" name="login" value="" placeholder="Login"/>

                        <b><c:out value="${password}"/></b>
                        <input type="password" name="password" value="" placeholder="Password"/>

                        <input type="submit" value=" <c:out value="${signin}"/>">

                        <i>
                            <c:if test="${not empty requestScope.errorMessage}">
                                <c:out value="${requestScope.errorMessage}"/>
                            </c:if>
                        </i>
                    </form>
                </div>
                <br/>
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="reg_page"/>
                    <input type="submit" value=" <c:out value="${regpage}"/>">
                </form>
            </div>
        </div>

    </div>
    <div class="separatorlogo"></div>
    <div class="main-container">
    </div>


</div>


</body>
</html>