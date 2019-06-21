<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 21.06.19
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>
<br><br><br>
The student is confirmed: ${student.firstName} ${student.lastName} from ${student.country} <br>
Favorte programming language: ${student.favProgrammingLang}
OS:
<ul>
    <c:forEach var="tmp" items="${student.operatingSystem}">

        <li>${tmp}</li>

    </c:forEach>
</ul>
<hr>
</body>
</html>
