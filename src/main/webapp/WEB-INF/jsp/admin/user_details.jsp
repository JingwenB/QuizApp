<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Detail</title>

</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>${user.firstName}'s Detail Page</h1>
    <p>viewing user details for ${user.firstName} ${user.lastName}</p>
    <h2>Basic Info</h2>
    <p>First name : ${user.firstName}</p>
    <p>Last name : ${user.lastName}</p>
    <p>Phone Number : ${user.phone}</p>
    <p>Email address : ${user.email}</p>
    <h2>Quiz History</h2>

    <table class="center">
        <thead>
        <tr>
            <th> Name</th>
            <th> Category</th>
            <th> Start Time</th>
            <th> End time</th>
            <th> Grade</th>
            <th> Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quizzes}" var="quiz">
            <tr>
                <td> ${quiz.name} </td>
                <td> ${quiz.category} </td>
                <td> ${quiz.time_start} </td>
                <td> ${quiz.time_end} </td>
                <td> ${quiz.grade} </td>
                <td><a href="${pageContext.request.contextPath}/admin_quiz_details?quiz_id=${quiz.id}">details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Quiz Analysis</h2>
</div>

</body>


</html>