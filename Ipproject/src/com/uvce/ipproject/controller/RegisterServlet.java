package com.uvce.ipproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uvce.ipproject.Dao.userDao;
import com.uvce.ipproject.entity.user;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd  = null;
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		user u = new user();
		
		
		u.setFname(fname);
		u.setLname(lname);
		u.setUsername(user_id);
		u.setPassword(password);
		u.setEmail(email);
		u.setPhone(phone);
		u.setGender(gender);
		
		int status  = userDao.save(u);
		if(status > 0 )
		{
			out.println("<p>record saved successfully!!! login to get authenticated</p>");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("<p>sorry unable to process the request</p>");
			rd = request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
		}
	
		
		
	}

}
