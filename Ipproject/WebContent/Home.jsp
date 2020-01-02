<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import = "java.sql.Connection" %>
    <%@page import = "java.sql.ResultSet" %>
    <%@page import = "java.sql.Statement" %>
    <%@page import = "com.uvce.ipproject.Dao.userDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel = "stylesheet" href = "home.css">
</head>
<body>
<h1>SureVac Customer Portal </h1><br>
<a href = "LogoutServlet">logout</a>
<form action = "HomeServlet" method = "post">
<div class = "wrap">
<h2>Register a complaint</h2>
<%  Connection con = null;
	con = userDao.getConnection();
	try {
		Statement st = con.createStatement();
		String sql = "select pname from product";
		ResultSet rs = st.executeQuery(sql);
%>
<% while(rs.next()) { %>
<div id = "radio-group">
<label class = "radio">
<input type = "radio" name = "setval"  value = <%= rs.getString(1) %>>
<%= rs.getString(1) %>
</label>
<span></span>
<%}  %>
<% }catch(Exception e)
{
	e.printStackTrace();
}
%>
<br><br><br>
</div>
<input type = "text" name = "reason" placeholder = "enter the complaint">
<input type = "submit" value = "submit">
</div>
</form>
</body>
</html>