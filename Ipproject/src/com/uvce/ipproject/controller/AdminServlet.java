package com.uvce.ipproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uvce.ipproject.Dao.AdminDao;
import com.uvce.ipproject.Dao.userDao;
import com.uvce.ipproject.entity.product;
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");	
	PrintWriter out = response.getWriter();
	
	int pid = Integer.parseInt(request.getParameter("pid"));
	String pname = request.getParameter("pname");
	
	int status = 0;
	product p = new product();
	p.setPid(pid);
	p.setPname(pname);
	
	status = AdminDao.insertvalues(p);
	if(status>0)
	{
		out.print("<p>record inserted successfully"
				+ "please go back and refresh</p>");
	}
	else
	{
		out.print("<p>something unexpected happened</p>");
	}
	
	
	
	Connection con = null;
	con = userDao.getConnection();
	try {
		Statement st = con.createStatement();
		String sql = "select * from product";
		ResultSet rs = st.executeQuery(sql);
		
		out.println("<table >"
				+"<tr><th>Product Id</th><th>product Name</th></tr>");
		while(rs.next())
		{
			int i = rs.getInt(1);
			String str = rs.getString(2);
			
			out.print("<tr><td><center>"+rs.getInt(1)+"</center></td>"
					+"<td><center>"+rs.getString(2)+"</center></td></tr>");
				
		}
		out.print("</table>");
		response.sendRedirect("Admin.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
		
		
	}

}
