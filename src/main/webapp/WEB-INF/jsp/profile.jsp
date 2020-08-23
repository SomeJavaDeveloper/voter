<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <title>Profile</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <base href="${pageContext.request.contextPath}/"/>
<body>
<section>
    <%--<form:form class="form-group" modelAttribute="userTo" method="post" action="profile"--%>
    <%--           charset="utf-8" accept-charset="UTF-8">--%>

    <%--    <topjava:inputField labelCode="user.name" name="name"/>--%>
    <%--    <topjava:inputField labelCode="user.email" name="email"/>--%>
    <%--    <topjava:inputField labelCode="user.password" name="password" inputType="password"/>--%>
    <%--    <topjava:inputField labelCode="user.caloriesPerDay" name="caloriesPerDay" inputType="number"/>--%>

    <%--    <div class="text-right">--%>
    <%--        <a class="btn btn-secondary" href="#" onclick="window.history.back()">--%>
    <%--            <span class="fa fa-close"></span>--%>
    <%--            <spring:message code="common.cancel"/>--%>
    <%--        </a>--%>
    <%--        <button type="submit" class="btn btn-primary">--%>
    <%--            <span class="fa fa-check"></span>--%>
    <%--            <spring:message code="common.save"/>--%>
    <%--        </button>--%>
    <%--    </div>--%>
    <%--</form:form>--%>

    <h3>${userTo.name}</h3>

    <jsp:useBean id="user" class="ru.vote.testtask.to.UserTo" scope="request"/>

    <form method="post" action="${register ? 'profile/register' : 'profile'}">
        <input type="hidden" name="id" value="${userTo.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${userTo.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${userTo.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input type="password" value="${userTo.password}" name="password" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
