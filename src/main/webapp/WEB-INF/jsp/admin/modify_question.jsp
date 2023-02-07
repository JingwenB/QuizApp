<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Modify Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>

        .container {
            width: 50%;
            padding: 50px;
            background-color: #f1f1f1;
            margin-left: auto;
            margin-right: auto;
        }

        input {
            transition: all 0.3s ease 0s;
        }

        input[type=text], textarea {
            width: 50%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #fdfdfd;
        }

        div {
            padding: 10px 0;
        }


    </style>
</head>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Modify Question ID:${question.id}</h1>
    <p></p>

    <form method="post" action="/modify_question">
        <div class="container">
            <h2>Modify Form</h2>
            <p>Note: can't change question category from this form <br/>
            Only entered information will be updated</p>
            <hr>

            <br>
            <div>
                <br>
                <label> Change Question Description </label>
                <br>
                <textarea cols="80" rows="5" placeholder="${question.description}" name="description">${question.description}</textarea>
            </div>
            <br>
            <hr>

            <label>
                Choice 1:
            </label>
            <input type="text" name="choice_1" value="${question.choices.get(0).description}" />
            <br>

            <label>
                Choice 2:
            </label>
            <input type="text" name="choice_2" value="${question.choices.get(1).description}" />
            <br>

            <label>
                Choice 3:
            </label>
            <input type="text" name="choice_3" value="${question.choices.get(2).description}" />
            <br>

            <label>
                Choice 4:
            </label>
            <input type="text" name="choice_4" value="${question.choices.get(3).description}" />
            <br>

            <label>
                Select the correct answer:
            </label>
            <select name="correct_answer_index" required>
                <option value="0">-- please reselect correct answer(required) --</option>
                <option value="0">Choice 1</option>
                <option value="1">Choice 2</option>
                <option value="2">Choice 3</option>
                <option value="3">Choice 4</option>
            </select>

            <br/>

            <input style="margin-top: 25px;margin-bottom: 25px;" type="submit" value="Modify This Question"/>
        </div>
    </form>


</div>
</body>

</html>