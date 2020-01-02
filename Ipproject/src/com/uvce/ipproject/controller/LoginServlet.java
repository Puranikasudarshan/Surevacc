package com.uvce.ipproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uvce.ipproject.Dao.userDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		if(userid.equals("admin") && password.equals("admin"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("name",userid);
			RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.print("wrong credentials");
		}
		if(userDao.validate(userid, password))
		{
			response.sendRedirect("Home.jsp");
			
		}
		else
		{
			out.println("<p>sorry username and password are wrong!!!!</p>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
		
		
	}

}