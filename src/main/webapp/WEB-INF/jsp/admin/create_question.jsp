<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Create Question</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Calibri, Helvetica, sans-serif;
        }

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

        hr {
            border: 1px solid #d8d8d8;
            margin-bottom: 25px;
        }

    </style>
</head>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Create A New Question</h1>
    <p></p>

    <form method="post" action="/create_question">
        <div class="container">
            <h2> Creation Form</h2>
            <hr>

            <div>
                <label>
                    Select a Question Category :
                </label>

                <select name="category" required>
                    <option value="Math">-- please select a category --</option>
                    <option value="Math">Math</option>
                    <option value="Chemistry">Chemistry</option>
                    <option value="Biology">Biology</option>
                </select>
            </div>
            <br>
            <div>
                <br>
                <label> Question Description </label>
                <br>
                <textarea cols="80" rows="5" placeholder="Enter question description Address" name="description"
                          required>
</textarea>
            </div>
            <br>
            <hr>

            <label>
                Choice 1:
            </label>
            <input type="text" name="choice_1" placeholder="Enter Choice 1 description" required/>
            <br>

            <label>
                Choice 2:
            </label>
            <input type="text" name="choice_2" placeholder="Enter Choice 2 description" required/>
            <br>

            <label>
                Choice 3:
            </label>
            <input type="text" name="choice_3" placeholder="Enter Choice 3 description" required/>
            <br>

            <label>
                Choice 4:
            </label>
            <input type="text" name="choice_4" placeholder="Enter Choice 4 discrption" required/>
            <br>

            <label>
                Select the correct answer:
            </label>
            <select name="correct_answer_index" required>
                <option value="0">-- please select correct answer --</option>
                <option value="0">Choice 1</option>
                <option value="1">Choice 2</option>
                <option value="2">Choice 3</option>
                <option value="3">Choice 4</option>
            </select>

            <br/>

            <input style="margin-top: 25px;margin-bottom: 25px;" type="submit" value="Create This Question"/>
        </div>
    </form>


</div>
</body>

</html>