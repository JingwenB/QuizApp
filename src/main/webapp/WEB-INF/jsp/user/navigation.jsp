<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color:#f1f1f1;
    }


    li a {
        display: block;
        color:#000;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover:not(.active) {
        background-color: #555;
        color: white;
    }

    .active {
        background-color: darkgreen;
        color: white;
    }
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