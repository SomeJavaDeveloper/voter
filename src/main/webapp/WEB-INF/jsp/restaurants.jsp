<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Restaurant Vote</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <a href="profile">${userTo.name}</a>

    <sec:authorize access="isAuthenticated()">
        <form action="logout" method="post">
            <sec:authorize access="hasRole('ADMIN')">
                <a href="users">Users</a>
            </sec:authorize>
            <a href="profile"><sec:authentication property="principal.userTo.name"/> profile</a>
            <button type="submit">
                Logout
            </button>
        </form>
    </sec:authorize>

    <hr/>
    <h2>Restaurants</h2>
    <br><br>
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('ADMIN')">
            <a href="restaurants/create">Add new restaurant</a>
        </sec:authorize>
    </sec:authorize>
        <c:forEach items="${restaurants}" var="restaurant">
            <jsp:useBean id="restaurant" type="ru.vote.testtask.to.RestaurantTo"/>

<%--            <h3><a href="restaurants/meals?restaurantId=${restaurant.id}">${restaurant.name}</a></h3>--%>
            <h3><a href="restaurants/${restaurant.id}/meals">${restaurant.name}</a></h3>
            <p>${restaurant.description}</p>

<%--            только админ--%>
            <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="restaurants/update?id=${restaurant.id}">Update</a>
                        <a href="restaurants/delete?id=${restaurant.id}">Delete</a>
                    </sec:authorize>
            </sec:authorize>

<%--            для всех--%>
            <a href="restaurants/vote?id=${restaurant.id}">Vote</a>
            <br>
        </c:forEach>
</body>
</html>
