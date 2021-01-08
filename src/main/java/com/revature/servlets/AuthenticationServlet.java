package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserAction;
import com.revature.models.Users;
import com.revature.util.ConnectionFactory;

public class AuthenticationServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	ObjectMapper om = new ObjectMapper();
	
	/*public List<Reimbursement> allReimbursements(int input){
    	Connection conn = this.cf.getConnection();
		
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		try {
			String sql = "select * from \"ExpenseSystem\".\"ers_reimbursement\" where \"reimb_status_id\"= " + input + ";";
			
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);
			
			
			while (res.next()) {
				Reimbursement c = new Reimbursement();
				c.setReimb_id(res.getInt("reimb_id"));
				c.setReimb_amount(res.getDouble("reimb_amount"));
				c.setReimb_submitted(res.getTimestamp("reimb_submitted"));
				c.setReimb_resolved(res.getTimestamp("reimb_resolved"));
				c.setReimb_description(res.getString("reimb_description"));
				all.add(c);
			}
		} catch (SQLException e) {
			
		} finally {
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
    return all;
    }*/
	
	public Users login(String username, String password) {
		Connection conn = this.cf.getConnection();
		Users c = new Users();
		//Reimbursement c = new Reimbursement();
		try {
			String sql = "select * from \"ERS\".\"ers_users\" where \"ers_users\".\"ers_username\" = '" + username 
					+ "' and \"ers_users\".\"ers_password\" = '" + password + "';";
			// we only use statements for very basic sql queries
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);
			
			
			if (res.next()) { 
				
				c.setErs_users_id(res.getInt("ers_users_id"));
				c.setErs_username(res.getString("ers_username"));
				c.setErs_password(res.getString("ers_password"));
				c.setUser_first_name(res.getString("user_first_name"));
				c.setUser_last_name(res.getString("user_last_name"));
				c.setUser_email(res.getString("user_email"));
				c.setUser_role_id(res.getInt("user_role_id"));
			}
			else {
				c = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
		
		return c;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*Users u= allReimbursements();
		response.setStatus(200);
		
		response.getWriter().write(om.writeValueAsString(u));
		response.setHeader("Content-Type", "application/json");*/
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//object mapper takes in JSON and turns to specified object, or vice versa
		UserAction userReimb = om.readValue(request.getInputStream(), UserAction.class);
		
			Users u= login(userReimb.getUsername(),userReimb.getPassword());
			response.setStatus(200);
			//user u = login(reimb.getusername, reimb.getpassword
			response.getWriter().write(om.writeValueAsString(u));
			response.setHeader("Content-Type", "application/json");
		
		/*Users cred = om.readValue(req.getInputStream(), Users.class);
		
		System.out.println(cred);
		boolean found = false;
		for(Users u : cred.size()) {
			if(cred.getErs_username().equals(u.getUsername()) && cred.getErs_password().equals(u.getPassword())) {
				resp.setStatus(200);
				resp.getWriter().write(om.writeValueAsString(u));
				resp.setHeader("Content-Type", "application/json");
				found = true;
				break;
			}
		}
		
		if(!found) {
			resp.setStatus(401);
			resp.getWriter().write("Username or Password Incorrect");
		}*/
	}
	
	

}
