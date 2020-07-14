<%--
  Created by IntelliJ IDEA.
  User: friday58
  Date: 30.06.2020
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Create restaurant' : 'Edit restaurant'}</h2>
    <jsp:useBean id="restaurant" type="ru.vote.testtask.model.Restaurant" scope="request"/>
    <form method="post" action="restaurants">
        <input type="hidden" name="id" value="${restaurant.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${restaurant.name}" name="name" required></dd>
        </dl>
        <input type="hidden" name="mealList" value="${restaurant.mealList}">
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="${restaurant.description}" name="description" required></dd>
        </dl>
        <button type="submit">Save</button>
<%--        передай параметы id и restaurant_id как параметры. url видит только get запрос--%>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
