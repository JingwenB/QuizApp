<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin Users</title>
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

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Users</h1>
    <p>viewing all non admin users</p>
</div>

<table class="center">
    <thead>
    <tr>
        <th> User Id</th>
        <th> Firstname</th>
        <th> Lastname</th>
        <th> Email</th>
        <th> No. Quizzes</th>
        <th> Overall Grades</th>
        <th> Details</th>
        <th> Is Active</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td> ${user.id} </td>
            <td> ${user.firstName} </td>
            <td> ${user.lastName} </td>
            <td> ${user.email} </td>
            <td> 0</td>
            <td> 0</td>
            <td><a href="${pageContext.request.contextPath}/details?user_id=${user.id}">details</a></td>
            <td>
                <c:choose>
                    <c:when test="${choice.active}">
                        <form method="post" action="/deactivate_user">
                            <button type="submit">
                                deactivate
                            </button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form method="post" action="/activate_user">
                            <button type="submit">
                                activate
                            </button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>


</html>