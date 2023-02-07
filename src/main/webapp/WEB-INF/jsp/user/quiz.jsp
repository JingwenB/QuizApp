<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quiz</title>

    <style>
        .container {
            width: 50%;
            padding: 50px;
            background-color: #f1f1f1;
            margin-left: auto;
            margin-right: auto;
            margin-top: 25px;
        }

        div {
            padding: 10px 0;
        }
    </style>
</head>

<body>
<%@ include file="navigation.jsp" %>
<div style="text-align:center">

    <h1>Take New Quiz</h1>

    <p>Choose a question category from below</p>

    <form method="post" action="setCategory">
        <label for="categories">Choose a category:</label>
        <select name="category" id="categories">
            <option value="" selected>--Please choose an option--</option>
            <option value="Math">Math</option>
            <option value="Chemistry">Chemistry</option>
            <option value="Biology">Biology</option>
        </select>

        <input type="submit" value="Submit">
    </form>

    <p>Click the "Submit" button to choose a quiz category.</p>


    <br/>
    <c:if test="${questions != null && questions.size() > 0}">
        <%--    <c:if test="${questions != null}">--%>

        <div class ="container">
        <h2>Please Finish Following ${sessionScope.category} Questions </h2>
            <br/>
        <p style="color:grey">
            You can reselect a category to render a new set of questions<br/>
        Note: You have to save all your answers before submitting your quiz </p>
        <hr/>


        <c:forEach items="${questions}" var="question" varStatus="question_count">

            <form method="post" action="/submitAnswer?questionId=${question.id}">

                    <%-- Question description --%>
                <p>
                    Q${question_count.index + 1} : ${question.description}</p>
                    <%-- Dynamically render the choices --%>
                <c:forEach items="${question.choices}" var="choice" varStatus="loop">
                    <div>
                        <input type="radio"
                               name="selectedChoiceId"
                               value="${choice.id}"/>
                            ${choice.description}
                    </div>
                </c:forEach>
                        <br/>
                <input type="submit" name="questionId" value="Save "/>

            </form>
            <hr style="width:50%"/>
<%--            <br/>--%>

        </c:forEach>
        <form method="post" action="/submitQuiz">
            <input type="submit" value="Submit Quiz">
        </form>

        </div>
    </c:if>



</div>
</body>
</html>
