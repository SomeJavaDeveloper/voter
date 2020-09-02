<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
    <sec:authorize access="isAuthenticated()">
        <form action="logout" method="post">
            <a href="/restaurants">Restaurants</a>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="users">Users</a>
            </sec:authorize>
            <a href="profile"><sec:authentication property="principal.userTo.name"/></a>
            <button type="submit">
                Logout
            </button>
        </form>
    </sec:authorize>
    <hr/>
</div>

