<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Manage All Users</title>
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
<%--        <th> No. Quizzes</th>--%>
<%--        <th> Overall Grades</th>--%>
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
                <%-- href=... calls get request [getUserDetails()] with url "user_details?user_id=${user.id}" --%>
            <td><a href="${pageContext.request.contextPath}/user_details?user_id=${user.id}">details</a></td>
            <td>
                <c:choose>
                    <%--Note: sent request parameter(user_id, is_active) withing url--%>
                    <c:when test="${user.active}">
                        <form method="post" action="/user_status?user_id=${user.id}&is_active=${user.active}">
                            <button type="submit">
                                deactivate
                            </button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form method="post" action="/user_status?user_id=${user.id}&is_active=${user.active}">
                                <%--<button type="submit" name="user_id" value=${user.id}>--%>
                            <button type="submit" >
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