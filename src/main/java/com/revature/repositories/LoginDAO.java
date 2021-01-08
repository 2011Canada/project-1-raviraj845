package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.util.ConnectionFactory;

public class LoginDAO {
	
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	
	
	public boolean validate(String username, String password) {
		
		Connection conn = this.cf.getConnection();
		boolean status=false;
		
		try {
			
			String sql ="\"select * from \\\"ERS\\\".\\\"login\\\" where \\\"login\\\".\\\"username\\\" = '\" + username \r\n" + 
					"					+ \"' and \\\"login\\\".\\\"password\\\" = '\" + password + \"';";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			status= rs.next();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return status;
		
	
		
		
		
	}
	
	
	

}
