<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title style="text-align:center" >My Profile</title>
</head>

<body>

<%@ include file="user_navigation.jsp" %>
<div style="text-align:center">
<h1>My Profile</h1>
<p>My email address : ${sessionScope.user.email}</p>
<p>My first name : ${sessionScope.user.firstName}</p>
<p>My last name : ${sessionScope.user.lastName}</p>
</div>
</body>

</html>