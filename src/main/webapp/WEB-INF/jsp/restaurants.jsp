<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Restaurant Vote</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
    <h2>Restaurants</h2>
    <br><br>
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('ADMIN')">
            <a href="restaurants/create">Add new restaurant</a>
        </sec:authorize>
    </sec:authorize>
        <c:forEach items="${restaurants}" var="restaurant">
            <jsp:useBean id="restaurant" type="ru.vote.testtask.to.RestaurantTo"/>

            <h3><a href="restaurants/${restaurant.id}/meals">${restaurant.name}</a></h3>
            <p>${restaurant.description}</p>
            <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="restaurants/update?id=${restaurant.id}">Update</a>
                        <a href="restaurants/delete?id=${restaurant.id}">Delete</a>
                    </sec:authorize>
            </sec:authorize>
            <a href="restaurants/vote?id=${restaurant.id}">Vote</a>
            <br>
        </c:forEach>
</body>
</html>
