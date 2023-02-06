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
        <li style="float:left"><a href="${pageContext.request.contextPath}/admin_home">Home</a></li>

        <li style="float:left"><a href="${pageContext.request.contextPath}/admin_users">Users</a></li>
        <li style="float:left"><a href="${pageContext.request.contextPath}/admin_questions">Questions</a></li>

        <li style="float:left"><a href="${pageContext.request.contextPath}/admin_quizzes">Quizzes</a></li>

        <li style="float:left"><a href="${pageContext.request.contextPath}/admin_feedbacks">Feedbacks</a></li>
        <li style="float:right"><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
    </ul>
</nav>