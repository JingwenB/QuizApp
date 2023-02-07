<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Contact Us</title>
    <style>
        .container {
            width: 50%;
            padding: 50px;
            background-color: #f1f1f1;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
        }

        div {
            padding: 10px 0;
        }
    </style>
</head>

<body>

<%@ include file="navigation.jsp" %>
<div style="text-align:center">
    <h1>Contact Us</h1>
    <p>please fill out the following form to send us messages</p>
    <div class="container">
        <h1>Contact Form</h1>
        <hr/>
        <form method="post" action="/contact_us">
            <div>
                <label>Your First Name</label>
                <input type="text" name="firstName">

            </div>
            <div>
                <label>Your Last Name</label>
                <input type="text" name="lastName">
            </div>

            <div>
                <label>Enter Your subject</label>
                <input type="text" name="subject">
            </div>

            <div>
                <label>Your Message to us</label>
                <br/>
                <textarea name="message" rows="4" cols="50"></textarea>
            </div>

            <input type="submit" value="Submit">

        </form>
    </div>
</div>
</body>

</html>