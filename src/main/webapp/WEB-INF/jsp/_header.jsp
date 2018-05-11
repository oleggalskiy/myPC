<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="resources.local" var="loc" />
<div id="header">
    <a href="${pageContext.request.contextPath}/Controller?command=main_page"> <img src="${pageContext.request.contextPath}/img/logo.jpeg" alt="" width="322" height="127" class="logo" /></a>
    <div id="meta">
        <a href="${pageContext.request.contextPath}/Controller?command=main_page" class="meta1">${buttonHome}</a>
        <a href="#" class="meta2">${buttonSearch}</a>
        <a href="#" class="meta3">${buttonContact}</a>
        <a href="${pageContext.request.contextPath}/Controller?command=localization&local=ru"><img
                src="${pageContext.request.contextPath}/img/ru.gif" border="0" alt="">${buttonRu}</a>
        <a href="${pageContext.request.contextPath}/Controller?command=localization&local=en"><img
                src="${pageContext.request.contextPath}/img/en.gif" border="0" alt="">${buttonEn}</a>
    </div>
    <div id="menu">
        <ul>
            <li id="active"><a href="${pageContext.request.contextPath}/jsp/main.jsp">${buttonHome}</a></li>
            <li><a href="#">${buttonService}</a></li>
            <li><a href="#">${buttonAbout}</a></li>
            <li><a href="#">${buttonFaq}</a></li>
            <li><a href="#">${buttonForum}</a></li>
        </ul>
    </div>
    <div id="submenu">
        <!-- <ul class="first">
            <li><a href="#" id="over">Mission</a></li>
            <li><a href="#">Company</a></li>
            <li><a href="#">History</a></li>
            <li><a href="#">News</a></li>
        </ul> -->
    </div>
</div>