<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title style="text-align:center">History</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        table, th, td {
            border: 1px solid;
            text-align: center;
        }
        table.center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>

<body>

<%@ include file="user_navigation.jsp" %>


<div style="text-align:center">
    <h1>My Quiz History</h1>
    <h3>viewing all past quizzes</h3>
</div>

<table class="center">
    <thead>
    <tr>
        <th> Name </th>
        <th> Category </th>
        <th> Start Time </th>
        <th> End time </th>
        <th> Grade </th>
        <th> Details </th>
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
            <td> <a href="${pageContext.request.contextPath}/details?quiz_id=${quiz.id}" >details</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>

</html>