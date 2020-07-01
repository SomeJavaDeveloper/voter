
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${restaurantName}</title>
</head>
<body>
    <h1>${restaurantName}</h1>
    <a href="restaurantMeals?action=create">Add Meal</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <tr>
            <jsp:useBean id="meal" type="ru.vote.testtask.to.MealTo"/>
                <td>${meal.name}</td>
                <td>${meal.price}</td>
                <td><a href="restaurantMeals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="restaurantMeals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
