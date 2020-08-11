<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Vote</title>
    <link rel="stylesheet" href="resources/css/style.css">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Restaurants</h2>
    <br><br>
    <a href="restaurants/create">Add new restaurant</a>
        <c:forEach items="${restaurants}" var="restaurant">
            <jsp:useBean id="restaurant" type="ru.vote.testtask.to.RestaurantTo"/>

<%--            <h3><a href="restaurants/meals?restaurantId=${restaurant.id}">${restaurant.name}</a></h3>--%>
            <h3><a href="restaurants/${restaurant.id}/meals">${restaurant.name}</a></h3>
            <p>${restaurant.description}</p>

<%--            только админ--%>
            <a href="restaurants/update?id=${restaurant.id}">Update</a>
            <a href="restaurants/delete?id=${restaurant.id}">Delete</a>

<%--            для всех--%>
            <a href="restaurants/vote?id=${restaurant.id}">Vote</a>
            <br>
        </c:forEach>
</body>
</html>
