<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="../style.css" %>
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