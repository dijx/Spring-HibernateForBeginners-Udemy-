<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 08.07.19
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="Roles" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Admin's Page</title>
</head>
<body>
<h2>Sysadmins' page</h2>
<hr>
<p>Welcome, admin!</p>
<p>
    <%--    Display username and roles--%>
    User: <security:authentication property="principal.username"/>
</p>
<p>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>

</body>

<footer>
    <security:authorize access="isAuthenticated()">
        <form:form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Logout">
        </form:form>
    </security:authorize>

</footer>

</html>