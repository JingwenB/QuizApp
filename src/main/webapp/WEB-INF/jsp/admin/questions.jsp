<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Manager All Questions</title>
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

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Questions</h1>
    <p>viewing all questions</p>

</div>
<p>Choose a question category from below</p>
<form method="get" action="/getQuestionWithFilter">

    <label for="categories">Choose a category:</label>
    <select name="category" id="categories">
        <option value="" selected>--Please choose an option--</option>
        <option value="all">All</option>
        <option value="Math">Math</option>
        <option value="Chemistry">Chemistry</option>
        <option value="Biology">Biology</option>
    </select>
    <br/>
    <label for="is_active">Choose question status</label>
    <select name="is_active" id="is_active">
        <option value="" selected>--Please choose an option--</option>
        <option value="all">All</option>
        <option value="true">Active</option>
        <option value="false">Inactive</option>
    </select>
    <input type="submit" value="Submit">
</form>



<div style="text-align:center">
    <table class="center">
        <thead>
        <tr>

            <th> Question ID</th>
            <th> Category</th>
            <th> Description</th>
            <th> A</th>
            <th> B</th>
            <th> C</th>
            <th> D</th>
            <%--            <th> Correct Answer</th>--%>
            <th> Is Active</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">

            <tr>
                <td> ${question.id} </td>
                <td> ${question.category} </td>
                <td> ${question.description} </td>
                <c:forEach items="${question.choices}" var="choice">
                    <c:choose>
                        <c:when test="${choice.correct}">
                            <td style="color: green;font-weight:bold">
                                C${choice.id}: ${choice.description}
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td> C${choice.id}: ${choice.description} </td>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>

                <td>
                    <c:choose>
                        <%--Note: sent request parameter(user_id, is_active) withing url--%>
                        <c:when test="${question.active}">
                            <form method="post"
                                  action="/question_status?question_id=${question.id}&is_active=${question.active}">
                                <button type="submit">
                                    deactivate
                                </button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form method="post"
                                  action="/question_status?question_id=${question.id}&is_active=${question.active}">
                                    <%--<button type="submit" name="user_id" value=${user.id}>--%>
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
</div>
</body>

</html>