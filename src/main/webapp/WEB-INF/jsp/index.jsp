<%--
  Created by IntelliJ IDEA.
  User: friday58
  Date: 19.07.2020
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voter</title>
</head>
<body>
<h1>Restaurant vote</h1>
<form method="Post" action="users">
    <b>Type of user</b>
    <select name="userId">
        <option value="100000">User</option>
        <option value="100001">Admin</option>
    </select>
    <button type="submit">Select</button>
</form>
</body>
</html>
