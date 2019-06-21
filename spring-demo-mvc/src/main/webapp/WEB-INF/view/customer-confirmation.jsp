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
    <title>Customer confirmation</title>
</head>
<body>
<br><br><br>
The customer is confirmed: ${customer.firstName} ${customer.lastName}; free passes: ${customer.freePasses}
Postal code: ${customer.postalCode}
<hr>
</body>
</html>
