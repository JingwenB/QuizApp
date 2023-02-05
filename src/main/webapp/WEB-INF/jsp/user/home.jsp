<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title >User Home</title>
</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
<h1>User Home</h1>
    <p>This is the home page for user ${sessionScope.user.firstName}</p>
</div>
</body>

</html>