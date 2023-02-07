<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title style="text-align:center">My Profile</title>
</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>My Profile</h1>
    <br/>
    <p>My email address: ${sessionScope.user.email}</p>
    <p>My first Name: ${sessionScope.user.firstName}</p>
    <p>My last Name : ${sessionScope.user.lastName}</p>
    <p>My Phone Number : ${sessionScope.user.phone}</p>

</div>
</body>

</html>