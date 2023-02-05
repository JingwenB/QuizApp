<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>

<body>
<%-- div is for grouping items --%>
<div style="text-align:center">

    <h1>Log In</h1>
    <h3 style="color:grey">please login with your user name(email) and password</h3>

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
        <button type="submit">Submit</button>

    </form>
    <form method="post" action="/create_user">
        <button type="submit" >
            Register
        </button>
    </form>
</div>
</body>

</html>
