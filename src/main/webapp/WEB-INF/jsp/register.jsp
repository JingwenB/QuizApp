<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="style.css" %>
        .container {
            width: 50%;
            padding: 50px;
            background-color: #f1f1f1;
            margin-left: auto;
            margin-right: auto;
            text-align:center;
        }

        div {
            padding: 10px 0;
        }
        textarea {
            width: 50%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #fdfdfd;
            vertical-align: top
        }

    </style>
    <title>Login</title>
</head>

<body>
<%-- div is for grouping items --%>
<div class="container">
    <h1>Registration</h1>
    <h3 style="color:grey">please register a new account with your email and password</h3>
    <hr/>
    <form method="post" action="/register">
        <div>
            <label>Enter New Email</label>
            <input type="text" name="email">

        </div>
        <div>
            <label>Enter Your First Name</label>
            <input type="text" name="firstName">
        </div>

        <div>
            <label>Enter Your Last Name</label>
            <input type="text" name="lastName">
        </div>

        <div>
            <label>Enter Your Phone Number</label>
            <input type="text" name="phone">
        </div>

        <div>
            <label>Enter Your Address</label>
            <textarea cols="80" rows="5" name="address"></textarea>
        </div>
        <div>
            <label>Enter Password</label>
            <input type="password" name="password">
        </div>

        <input type="submit" value ="Submit">

    </form>
</div>
</body>

</html>
