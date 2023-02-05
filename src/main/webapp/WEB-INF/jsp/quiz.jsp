<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title >Quiz</title>
</head>

<body>
<%@ include file="user_navigation.jsp" %>
<div style="text-align:center">

    <h1>Take New Quiz</h1>

    <p>Choose a question category from below</p>

    <form method ="post" action="setCategory">
        <label for="categories" >Choose a category:</label>
        <select name="category" id="categories" >
            <option value="" selected>--Please choose an option--</option>
            <option value="Math">Math</option>
            <option value="Chemistry">Chemistry</option>
            <option value="Biology">Biology</option>
        </select>

        <input type="submit" value="Submit">
    </form>

    <p>Click the "Submit" button to choose a quiz category.</p>

</div>

<div>
    <br/>
    <c:if test="${questions != null && questions.size() > 0}">
<%--    <c:if test="${questions != null}">--%>

        <h2>Please Finish Following ${sessionScope.category} Questions </h2>
        <p style="color:grey">You can reselect a category to render a new set of questions </p>
        <br/>


        <c:forEach items="${questions}" var="question" varStatus="question_count">

            <form method="post" action="/submitAnswer">

                    <%-- Question description --%>
                <p>
                    Q${question_count.index + 1} : ${question.description}</p>

                    <%-- Dynamically render the choices --%>
                <c:forEach items="${question.choices}" var="choice" varStatus="loop">
                    <div>
                        <input type="radio"
                               name="selectedChoiceId"
                               value="${choice.id}" />

                            ${choice.description}
                    </div>
                </c:forEach>

                    <%-- Button to submit quiz --%>
<%--                        <div name="questionId" value="${question.id}>--%>
                <button type="submit" name="questionId" value="${question.id}">Save</button>
<%--                        </div>--%>

            </form>

        </c:forEach>
        <form method="post" action="/submitQuiz">
            <button type="submit" >Submit Quiz</button>
        </form>





    </c:if>





</div>
</body>
</html>
