<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Feedback</title>
</head>
<style>
    /* star reference:
    https://www.cssscript.com/simple-5-star-rating-system-with-css-and-html-radios/*/
    div.stars {
        width: 270px;
        display: inline-block;
    }

    input.star {
        display: none;
    }

    label.star {
        float: right;
        padding: 10px;
        font-size: 36px;
        color: #444;
        transition: all .2s;
    }

    input.star:checked ~ label.star:before {
        content: '\f005';
        color: #FD4;
        transition: all .25s;
    }

    input.star-5:checked ~ label.star:before {
        color: #FE7;
        text-shadow: 0 0 20px #952;
    }

    input.star-1:checked ~ label.star:before {
        color: #F62;
    }

    label.star:hover {
        transform: rotate(-15deg) scale(1.3);
    }

    label.star:before {
        content: '\f006';
        font-family: FontAwesome;
    }
</style>

<style>

    .container {
        width: 30%;
        padding: 50px;
        background-color: #f1f1f1;
        margin-left: auto;
        margin-right: auto;
        /*margin-top: 25px;*/
    }

    textarea {
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
<body>

<%@ include file="navigation.jsp" %>

<div style="text-align:center">
    <h1>Give Us Your Feedback</h1>
    <p>Please fill out the following form to submit a feedback to us</p>
    <br/>
    <div class="container">
        <h2>Feedback Form</h2>
        <hr/>
        <label>Your Rating</label>
        <form method="post" action="/feedback">
            <div class="stars">
                <input class="star star-5" id="star-5" type="radio" name="star" value="5"/>
                <label class="star star-5" for="star-5"></label>
                <input class="star star-4" id="star-4" type="radio" name="star" value="4"/>
                <label class="star star-4" for="star-4"></label>
                <input class="star star-3" id="star-3" type="radio" name="star" value="3"/>
                <label class="star star-3" for="star-3"></label>
                <input class="star star-2" id="star-2" type="radio" name="star" value="2"/>
                <label class="star star-2" for="star-2"></label>
                <input class="star star-1" id="star-1" type="radio" name="star" value="1"/>
                <label class="star star-1" for="star-1"></label>
            </div>

            <div>
                <p><label for="message">Your Message To Us:</label></p>
                <textarea id="message" name="message" rows="4" cols="50"></textarea>
                <br>
                <input type="submit" value="Submit Your Feedback">
            </div>
        </form>
    </div>

</div>
</body>

</html>