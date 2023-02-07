<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}style.css">--%>
    <style>
        <%@include file="style.css" %>
        .container {
            width: 30%;
            padding: 50px;
            background-color: #f1f1f1;
            margin-left: auto;
            margin-right: auto;
            text-align:center;
        }

        div {
            padding: 10px 0;
        }
    </style>

    <title>Login</title>
</head>

<body>
<%-- div is for grouping items --%>
<div class="container">

    <h1>Log In</h1>
    <h3 style="color:grey">please login with your user name(email) and password</h3>
    <hr/>
    <form method="post" action="/login">
        <div>
            <label>Username</label>
            <input type="text" name="username">
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <br/>
        <input type="submit" value="Log In">

    </form>
    <form method="post" action="/create_user">
        <input type="submit" value ="Register"/>
    </form>
</div>
</body>

</html>
