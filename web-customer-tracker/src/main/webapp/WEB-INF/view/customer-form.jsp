<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 01.07.19
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>

    <link
            type="text/css"
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link
            type="text/css"
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
    />


</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer relationship manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">

        <%--        Associate data with customer - needed for customer modification, otherwise duplicate entries will be created--%>
        <form:hidden path="id"/>


        <table>
            <tbody>
            <tr>
                <td><label>ID:</label></td>
                <td><input disabled="true" placeholder="${customer.id}"></input></td>
            </tr>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>

    </form:form>

    <div style="clear: both;">
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>

</div>

</body>
</html>
