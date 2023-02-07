<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title style="text-align:center">Quiz Detail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<%@ include file="navigation.jsp" %>


<div style="text-align:center">
    <h1>Quiz Detail</h1>
    <h3>viewing answering detail for ${quiz.name} </h3>

    <table class="center">
        <thead>
        <tr>
            <th> Order</th>
            <th> Status</th>
            <th> Question Description</th>
            <th> A</th>
            <th> B</th>
            <th> C</th>
            <th> D</th>
            <th> Correct Answer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${qqs}" var="qq">

            <tr>
                <td> Q${qq.order_num + 1} </td>
                <c:choose>
                    <c:when test="${qq.question.correct_choice.id == qq.user_choice_id }">
                        <td> Right</td>
                    </c:when>
                    <c:otherwise>
                        <td> Wrong</td>
                    </c:otherwise>
                </c:choose>
                <td> ${qq.question.description} </td>

                <c:forEach items="${qq.question.choices}" var="choice">
                    <c:choose>
                        <c:when test="${choice.id == qq.user_choice_id && choice.correct }">
                            <td style="
                            font-weight:bold;
                            background-color: #DFF0D8;
                            color: #3d773f"> ${choice.description} </td>
                        </c:when>
                        <c:when test="${choice.id == qq.user_choice_id && !choice.correct}">
                            <td style="font-weight:bold;
                            background-color: #F4CCCC;
                            color: #800000"> ${choice.description} </td>
                        </c:when>
                        <c:when test="${choice.correct}">
                            <td style="font-weight:bold;
                            background-color: #DFF0D8;
                            color: #3d773f"> ${choice.description} </td>
                        </c:when>
                        <c:otherwise>
                            <td> ${choice.description} </td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <td> ${qq.question.correct_choice.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>Use the following link to take a new quiz</h2>
    <form method="get"
          action="/user_quiz">
        <input type="submit" value="Take Another Quiz"/>
    </form>
</div>


</body>

</html>