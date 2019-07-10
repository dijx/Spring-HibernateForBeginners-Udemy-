<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 08.07.19
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>SpringMVC test home page</h2>
<hr>
<p>Welcome</p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>
</body>
</html>
