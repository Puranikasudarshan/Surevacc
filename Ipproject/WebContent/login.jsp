<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1 style = "color:red; text-align:center">SureVac Customer Portal </h1>
<form action ="LoginServlet" method = "post">
<div class="login-box">
<h1>Login</h1>
<div class = "textbox">
<i class = "fa fa-user" aria-hidden="true"></i>
<input type = "text" placeholder="User-id" name = "user_id">
</div>
<div class = "textbox">
<i class = "fa fa-lock" aria-hidden="true"></i>
<input type = "password" placeholder="Password" name = "password">
</div>

<input class = "btn" type = "submit" value = "login">

<div class = "anchor">
New user <a href = "Register.jsp">click here</a>

</div>




</div>
</form>


</body>
</html>