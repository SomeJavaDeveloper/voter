
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>${restaurant.name}</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <h1>${restaurant.name}</h1>
    <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('ADMIN')">
            <a href="restaurants/${restaurant.id}/meals/create">Add Meal</a>
        </sec:authorize>
    </sec:authorize>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>id</th>

            <th>Name</th>
            <th>Price</th>
            <sec:authorize access="isAuthenticated()">
                <sec:authorize access="hasRole('ADMIN')">
                    <th></th>
                    <th></th>
                </sec:authorize>
            </sec:authorize>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <tr>
            <jsp:useBean id="meal" type="ru.vote.testtask.to.MealTo"/>

                <td>${meal.id}</td>

                <td>${meal.name}</td>
                <td>${meal.price}</td>
                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ADMIN')">
                        <td><a href="restaurants/${restaurant.id}/meals/update?id=${meal.id}">Update</a></td>
                        <td><a href="restaurants/${restaurant.id}/meals/delete?id=${meal.id}">Delete</a></td>
                    </sec:authorize>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
