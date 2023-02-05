<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Detail</title>
    <style>
        table, th, td {
            border: 1px solid;
            text-align: center;
            vertical-align: center;
            horiz-align: center;
        }

        table.center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>${user.firstName}'s Detail Page</h1>
    <p>viewing user details for ${user.firstName} ${user.lastName}</p>
    <h2>Basic Info</h2>
    <p>Email address : ${user.email}</p>
    <p>First name : ${user.firstName}</p>
    <p>Last name : ${user.lastName}</p>
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
                <td><a href="${pageContext.request.contextPath}/details?quiz_id=${quiz.id}">details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Quiz Analysis</h2>
</div>

</body>


</html>