<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin Feedbacks</title>
</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Feedbacks</h1>
    <p>viewing all feedbacks</p>


    <p>Our Overall rating: ${overall_rate}</p>
    <table class="center">
        <thead>
        <tr>

            <th> ID </th>
            <th> User</th>
            <th> Rating </th>
            <th> Message </th>
            <th> Date </th>
            <th> User Details </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${feedbacks}" var="feedback">

            <tr>
                <td> ${feedback.id} </td>
                <td> ${feedback.user.firstName} ${feedback.user.lastName}</td>
                <td> ${feedback.rating} </td>
                <td> ${feedback.message} </td>
                <td> ${feedback.date} </td>
                <td><a href="${pageContext.request.contextPath}/user_details?user_id=${feedback.user_id}">details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>


</html>