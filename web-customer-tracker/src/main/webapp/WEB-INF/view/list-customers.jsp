<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 01.07.19
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers listing</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer relationship manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <input type="button" value="Add/Edit Customer"
               onclick="window.location.href='showFormForAdd' ; return false"
               class="add-button"
        />

        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">

                <%--                Construct update link with customer ID--%>
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>

                </c:url>

                <%--                Construct delete customer link--%>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>

                </c:url>

                <tr>
                    <td>${tempCustomer.id}</td>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>

                        <%--                    Customer update link--%>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="#"
                           onclick="deleteUserConfirmation('${deleteLink}', '${tempCustomer.email}')">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script type="text/javascript">

    function deleteUserConfirmation(deleteLocation, customerMail) {

        if (confirm("Are you sure you want to delete user:\n" + customerMail + "?")) {

            window.location.href = deleteLocation
        }
    }

</script>


</body>
</html>
