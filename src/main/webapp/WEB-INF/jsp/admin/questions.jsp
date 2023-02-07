<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Manager All Questions</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">

    <h1>Questions</h1>
    <p>viewing all questions</p>

    <br/>
    <p>Choose a filters from below</p>
    <form method="get" action="/getQuestionsWithFilter">

        <label for="categories">Choose a category:</label>
        <select name="category" id="categories">
            <option value="" selected>--Please choose an option--</option>
            <option value="all">All</option>
            <option value="Math">Math</option>
            <option value="Chemistry">Chemistry</option>
            <option value="Biology">Biology</option>
        </select>
        <br/>
        <br/>
        <label for="is_active">Choose question status</label>
        <select name="is_active" id="is_active">
            <option value="" selected>--Please choose an option--</option>
            <option value="all">All</option>
            <option value="true">Active</option>
            <option value="false">Inactive</option>
        </select>
        <br/>
        <br/>
        <input type="submit" value="Submit">
    </form>



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
                            <td style="
                            background-color: #DFF0D8;
                            font-weight:bold;
                            color: #3d773f">
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
                            <label>Yes</label>
                            <form method="post"
                                  action="/question_status?question_id=${question.id}&is_active=${question.active}">
                                <input type="submit" value="deactivate"
                                       style="background-color: #F4CCCC;
                                       color: #800000"/>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <label>No</label>
                            <form method="post"
                                  action="/question_status?question_id=${question.id}&is_active=${question.active}">
                                <input type="submit" value="activate"
                                style="background-color: #DFF0D8;
                                color: #3d773f"/>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <br/>
    <br/>
    <hr/>

    <h2>Create A Question</h2>
    <p>Please use the following link to submit a form to create a new question</p>
    <br/>
<%--    <hr/>--%>
    <form method="get"
          action="/create_question">
        <input type="submit" value="Create New Question"/>
    </form>


</div>
</body>

</html>