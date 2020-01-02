<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel = "stylesheet" href = "registerstyle.css">
</head>
<body>
<h1>SureVac Customer Portal </h1>
<div class = "wrap">
<h2> Register Page</h2>
<form action = "RegisterServlet" method = "post">
<input type = "text" placeholder = "username" name = "user_id">
<input type = "text" placeholder = "First Name" name = "fname">
<input type = "text" placeholder = "Last name" name = "lname">
<input type = "password" placeholder = "password" name = "password">
<input type = "text" placeholder = "Email" name = "email">
<input type = "text" placeholder = "Phone" name = "phone">
<div class = "radio-group">
<label class = "radio">
<input type = "radio" name = "gender" value = "male">
Male
<span></span>
</label>
<label class = "radio">
<input type = "radio" name = "gender" value = "female">
Female
<span></span>
</label>
</div>
<input type = "submit" value = "Register">
</form>
</div>


<div class = "anchor">
Already have an account   <a href = "login.jsp">click here</a>
</div>








</body>
</html>