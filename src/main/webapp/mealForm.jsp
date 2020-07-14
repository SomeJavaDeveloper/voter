<%--
  Created by IntelliJ IDEA.
  User: friday58
  Date: 02.07.2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Create meal' : 'Edit meal'}</h2>
    <jsp:useBean id="meal" type="ru.vote.testtask.model.Meal" scope="request"/>
    <form method="post" action="restaurantMeals">
        <input type="hidden" name="id" value="${meal.id}">
        <input type="hidden" name="restaurantId" value="${param.restaurant_id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${meal.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="text" value="${meal.price}" name="price" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
