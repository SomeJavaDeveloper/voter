<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Profile</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<section>
    <h3>${userTo.name}</h3>

    <jsp:useBean id="userTo" class="ru.vote.testtask.to.UserTo" scope="request"/>

<%--    <form method="post" action="${register ? 'profile/register' : 'profile'}">--%>
        <form method="post" action="profile/register">
        <input type="hidden" name="id" value="${userTo.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${userTo.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${userTo.email}" name="email" required></dd>
        </dl>
        <sec:authorize access="!isAuthenticated()">
            <dl>
                <dt>Password:</dt>
                <dd><input type="password" value="${userTo.password}" name="password" required></dd>
            </dl>
        </sec:authorize>
<%--        <sec:authorize access="isAuthenticated()">--%>
<%--                <dd><input type="hidden" value="updated" name="password" required></dd>--%>
<%--        </sec:authorize>--%>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
