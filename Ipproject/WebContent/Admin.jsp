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
<title>administration-Page</title>
<link rel = "stylesheet" href = "admin.css">
</head>
<body>
<h1>Administration page</h1>
<a href = "LogoutServlet">logout</a>

<% 	Connection con = null;
	con = userDao.getConnection();
	try {
		Statement st = con.createStatement();
		String sql = "select * from product order by pid";
		ResultSet rs = st.executeQuery(sql);
%>
<table border = 1 cellpadding=0 cellspacing=0 width=100%>
<tr>
<th>Product-Id</th><th>Product-Name</th></tr>
<tr>
<% while(rs.next()) { %>
<tr><td><center><%=rs.getInt(1) %></center></td>
<td><center><%=rs.getString("pname") %></center></td>
</tr>
<%}  %>
<% }catch(Exception e)
{
	e.printStackTrace();
}
%>
</table>
<div class = "row">
<div class = "column">
<form action = "AdminServlet" method = "post">
<h3>Add products</h3>
<input type = "number" name = "pid" placeholder = "product-id">
<input type = "text" name = "pname" placeholder = "product-name">
<input type = "submit" value = "add">
</form>
</div>
</div>

</body>
</html>