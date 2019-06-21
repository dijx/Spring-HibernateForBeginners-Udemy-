<%--
  Created by IntelliJ IDEA.
  User: dx
  Date: 21.06.19
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">

        <%--            <form:option value="Brazil" label="Brazil" />--%>
        <%--            <form:option value="Poland" label="Poland" />--%>
        <%--            <form:option value="Japan" label="Japan" />--%>
        <%--            <form:option value="Vietnam" label="Vietnam" />--%>

        <form:options items="${student.countryOptions}"/>

    </form:select>
    <br><br>

    Favorite programming language:
    JAVA <form:radiobutton path="favProgrammingLang" value="Java"/>
    C# <form:radiobutton path="favProgrammingLang" value="C#"/>
    PHP <form:radiobutton path="favProgrammingLang" value="PHP"/>
    RUBY <form:radiobutton path="favProgrammingLang" value="RUBY"/>


    <br><br>
    Operating system:
    <form:checkboxes path="operatingSystem" items="${OS}"/>


    <br><br>

    <input type="submit" value="Submit">

</form:form>


</body>
</html>
