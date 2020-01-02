package com.uvce.ipproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uvce.ipproject.Dao.userDao;
import com.uvce.ipproject.entity.complaint;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		con = userDao.getConnection();
	
		
		String pname = request.getParameter("setval");
		String reason = request.getParameter("reason");
		
		
		complaint c = new complaint();
		c.setPname(pname);
		c.setReason(reason);
		int status = userDao.insert(c);
		if(status > 0)
		{
			
			response.sendRedirect("complaint.jsp");
			
		}
		else
		{
			out.print("<p>something went wrong</p>");
		}
		
		

}
}
