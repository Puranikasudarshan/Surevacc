package com.uvce.ipproject.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.uvce.ipproject.Dao.userDao;
import com.uvce.ipproject.entity.product;

public class AdminDao {
	
	public static int insertvalues(product p)
	{
		int status = 0;
		Connection con = null;
		con = userDao.getConnection();
		String sql = "insert into product(pid,pname) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			status = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return status;
		
		
		
	}
	
	
	
	
	
	

}
