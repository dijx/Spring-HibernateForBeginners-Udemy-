<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 09.07.19
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Custom Plain Login</title>
</head>
<body>
<h3>Custom login page</h3>

<c:choose>
    <c:when test="${param.error != null}">
        <i style="color: red">Invalid user or password. Try again.</i>
    </c:when>
    <c:otherwise>
        <i>Enter user and password...</i>
    </c:otherwise>
</c:choose>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <p>
        User name: <input type="text" name="username"/>
    </p>
    <p>
        Password: <input type="password" name="password"/>
    </p>
    <input type="submit" value="Login"/>

</form:form>

</body>
</html>
