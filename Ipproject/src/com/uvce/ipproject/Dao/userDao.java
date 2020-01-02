package com.uvce.ipproject.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.uvce.ipproject.entity.user;
import com.uvce.ipproject.entity.complaint;

public class userDao {

	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iplab", "root", "root");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int save(user u)
	{
		int status = 0;
		Connection con = userDao.getConnection();
		String query = "insert into user(username,fname,lname,email,phone,password,gender) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getFname());
			ps.setString(3, u.getLname());						
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getPhone());
			ps.setString(6, u.getPassword());
			ps.setString(7, u.getGender());
			status =  ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	public static boolean validate(String userid, String password)
	{
		boolean status = false;
		Connection con = userDao.getConnection();
		String query = "select * from user where username = ? and password = ?";
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static String welcome(String userid ,String password)
	{
		Connection con = userDao.getConnection();
		String query = "select fname,lname from user where username = ? and password = ?";
		String name = null;
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userid);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				name = rs.getString(1)+" "+rs.getString(2);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return name;
	}
	
	public static int insert(complaint c)
	{
		Connection con = userDao.getConnection();
		String query = "insert into complaint(pname,reason) values(?,?)";
		int status = 0;
		try
		{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, c.getPname());
			ps.setString(2, c.getReason());
			status =  ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
		
	}
	
	
}

