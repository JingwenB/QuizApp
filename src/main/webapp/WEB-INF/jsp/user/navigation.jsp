<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link rel="stylesheet" href="../style.css">--%>
<style>
    <%@include file="../style.css" %>
</style>

<nav>
    <ul>

        <li style="float:left"><a href="${pageContext.request.contextPath}/user_home">Home</a></li>
        <li style="float:left"><a href="${pageContext.request.contextPath}/user_profile">My Profile</a></li>
        <li style="float:left"><a href="${pageContext.request.contextPath}/user_history">Quiz History</a></li>
        <li style="float:left"><a href="${pageContext.request.contextPath}/user_quiz">Take New Quiz</a></li>

        <li style="float:right"><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
        <li style="float:right"><a href="${pageContext.request.contextPath}/feedback">Submit Feedback</a></li>
        <li style="float:right"><a href="${pageContext.request.contextPath}/contact_us">Contact Us</a></li>

    </ul>
</nav>