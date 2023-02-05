<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>

<body>
<%-- div is for grouping items --%>
<div style="text-align:center">
    <h1>Registration</h1>
    <h3 style="color:grey">please register a new account with your email and password</h3>
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
            <label>Enter Your First Name</label>
            <input type="text" name="lastName">
        </div>

        <div>
            <label>Enter New Password</label>
            <input type="password" name="password">
        </div>
        <button type="submit">Submit</button>

    </form>
</div>
</body>

</html>
