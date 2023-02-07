<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Quizzes</h1>
    <p>viewing all quizzes</p>
    <br/>

    <p>Choose a filter from below</p>
    <form method="get" action="/getQuizzesWithFilter">

        <label for="categories">Choose a category:</label>
        <select name="category" id="categories">
            <option value="" selected>--Please choose an option--</option>
            <option value="all">All Categories</option>
            <option value="Math">Math</option>
            <option value="Chemistry">Chemistry</option>
            <option value="Biology">Biology</option>
        </select>
        <br/>
        <label for="user_id">Choose a user</label>
        <select name="user_id" id="user_id">
            <option value="" selected>--Please choose an option--</option>
            <option value="all">All Users</option>
            <c:forEach items="${sessionScope.users}" var="user">
                <option value="${user.id}">${user.firstName} ${user.lastName}</option>
            </c:forEach>

        </select>
        <input type="submit" value="Submit">
    </form>

    <table class="center">
        <thead>
        <tr>
            <th> ID</th>
            <th> Name</th>
            <th> Category</th>
            <th> Start Time</th>
            <th> End time</th>
            <th> User ID</th>
            <th> User Name</th>
            <th> Grade</th>
            <th> Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quizzes}" var="quiz">
            <tr>
                <td> ${quiz.id} </td>
                <td> ${quiz.name} </td>
                <td> ${quiz.category} </td>
                <td> ${quiz.time_start} </td>
                <td> ${quiz.time_end} </td>
                <td> ${quiz.user.id} </td>
                <td> ${quiz.user.firstName} ${quiz.user.lastName}</td>
                <td> ${quiz.grade} </td>
                <td><a href="${pageContext.request.contextPath}/admin_quiz_details?quiz_id=${quiz.id}">details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>

</html>