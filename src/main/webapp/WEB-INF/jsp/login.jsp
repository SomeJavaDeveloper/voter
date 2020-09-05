<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Login</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <div>
        <form action="spring_security_check" id="login_form" method="post">
            <h3>Login</h3>
            <p><input type="text" name="username"></p>
            <p><input type="password" name="password"></p>
            <button type="submit">
                Submit
            </button>
        </form>
    </div>
    <a href="profile/register">register</a>
</body>
</html>
