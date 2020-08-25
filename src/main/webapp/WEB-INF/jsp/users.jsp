<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h3><a href="index.html">Home</a></h3>
<hr/>
<h2>Users</h2>
<br><br>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <jsp:useBean id="user" type="ru.vote.testtask.model.User"/>

            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td><a href="users/update?id=${user.id}">Update</a></td>
            <td><a href="users/delete?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>