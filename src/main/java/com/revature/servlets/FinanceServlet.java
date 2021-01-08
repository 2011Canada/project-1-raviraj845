package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementAction;
import com.revature.util.ConnectionFactory;

/**
 * Servlet implementation class FinanceServlet
 */
public class FinanceServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	ObjectMapper om = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<Reimbursement> allReimbursements(){
    	Connection conn = this.cf.getConnection();
		
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		try {
			String sql = "select e.reimb_id,e.reimb_amount,e.reimb_description,\r\n"
					+ "e.reimb_submitted,e.reimb_resolved,\r\n"
					+ "e.reimb_resolver,ers_reimbursement_status.reimb_status,ers_reimbursement_type.reimb_type,\r\n"
					+ "ers_users.user_first_name,ers_users.user_last_name \r\n"
					+ "FROM \"ERS\".ers_reimbursement e\r\n"
					+ "INNER JOIN \"ERS\".ers_reimbursement_status ON e.reimb_status_id = ers_reimbursement_status.reimb_status_id\r\n"
					+ "INNER JOIN \"ERS\".ers_reimbursement_type ON e.reimb_type_id = ers_reimbursement_type.reimb_type_id\r\n"
					+ "INNER JOIN \"ERS\".ers_users on e.reimb_author = ers_users.ers_users_id " + ";";			
			//String sql = "select * from \"ExpenseSystem\".\"ers_reimbursement\" ;";
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);
			
			
			while (res.next()) {
				
				//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				
				
				
				Reimbursement c = new Reimbursement();
				c.setReimb_id(res.getInt("reimb_id"));
				c.setUser_first_name(res.getString("user_first_name"));
				c.setUser_last_name(res.getString("user_last_name"));
				c.setReimb_amount(res.getDouble("reimb_amount"));
				
				c.setReimb_status(res.getString("reimb_status"));
				if(res.getTimestamp("reimb_submitted")!= null) {
					Date d =new Date(res.getTimestamp("reimb_submitted").getTime());	
					c.setTs(d.toString());
				}
				else {
					c.setTs("");
				}
				if(res.getTimestamp("reimb_resolved")!= null) {
					Date d =new Date(res.getTimestamp("reimb_resolved").getTime());	
					c.setRs(d.toString());
				}
				else {
					c.setRs("");
				}
				
				//res.getTimestamp("reimb_resolved")
				c.setReimb_description(res.getString("reimb_description"));
				all.add(c);
				//System.out.println(new Date(res.getTimestamp("reimb_submitted").getTime()));
				//System.out.println(d);
			}
			
			

		} catch (SQLException e) {
			

		} finally {
			
		
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
    return all;
    }
    
    
    public List<Reimbursement> allReimbursements(int input){
    	Connection conn = this.cf.getConnection();
		
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		try {
			String sql = "select e.reimb_id,e.reimb_amount,e.reimb_description,\r\n"
					+ "e.reimb_submitted,e.reimb_resolved,\r\n"
					+ "e.reimb_resolver,ers_reimbursement_status.reimb_status,ers_reimbursement_type.reimb_type,\r\n"
					+ "ers_users.user_first_name,ers_users.user_last_name \r\n"
					+ "FROM \"ERS\".ers_reimbursement e\r\n"
					+ "INNER JOIN \"ERS\".ers_reimbursement_status ON e.reimb_status_id = ers_reimbursement_status.reimb_status_id\r\n"
					+ "INNER JOIN \"ERS\".ers_reimbursement_type ON e.reimb_type_id = ers_reimbursement_type.reimb_type_id\r\n"
					+ "INNER JOIN \"ERS\".ers_users on e.reimb_author = ers_users.ers_users_id " 
					+ "WHERE e.reimb_status_id= " + input + ";";
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);
			
			
			while (res.next()) {

				Reimbursement c = new Reimbursement();
				c.setReimb_id(res.getInt("reimb_id"));
				c.setUser_first_name(res.getString("user_first_name"));
				c.setUser_last_name(res.getString("user_last_name"));
				c.setReimb_amount(res.getDouble("reimb_amount"));
				
				c.setReimb_status(res.getString("reimb_status"));
				if(res.getTimestamp("reimb_submitted")!= null) {
					Date d =new Date(res.getTimestamp("reimb_submitted").getTime());	
					c.setTs(d.toString());
				}
				else {
					c.setTs("");
				}
				if(res.getTimestamp("reimb_resolved")!= null) {
					Date d =new Date(res.getTimestamp("reimb_resolved").getTime());	
					c.setRs(d.toString());
				}
				else {
					c.setRs("");
				}
				
				//res.getTimestamp("reimb_resolved")
				c.setReimb_description(res.getString("reimb_description"));
				all.add(c);
				//System.out.println(new Date(res.getTimestamp("reimb_submitted").getTime()));
		
			}
		} catch (SQLException e) {
			
		} finally {
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
    return all;
    }
    
    
    
	public Reimbursement updateReimbursement(int reimb_status_id, int reimb_id) {
		Connection conn = cf.getConnection();
		Scanner userIn = new Scanner(System.in);
		
		Reimbursement c = new Reimbursement();
		try {
		
			conn.setAutoCommit(false);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String updateReimb = "";
				if(reimb_status_id == 1) {
					updateReimb = "Update \"ERS\".\"ers_reimbursement\" set \"reimb_status_id\"=" + 
							reimb_status_id + ",\"reimb_resolved\"='"+ timestamp.toString() +"' where \"reimb_id\" = " + reimb_id +"returning \"reimb_status_id\";";
					
				}
				else {
					//Update "ExpenseSystem"."ers_reimbursement" set "reimb_status_id"= 2,"reimb_resolved"=null where "reimb_id" = 8;
					updateReimb = "Update \"ERS\".\"ers_reimbursement\" set \"reimb_status_id\"=" + 
							reimb_status_id + ",\"reimb_resolved\"=null where \"reimb_id\" = " + reimb_id +"returning \"reimb_status_id\";";
				}
				
				// we only use statements for very basic sql queries
				Statement s = conn.createStatement();

				ResultSet res = s.executeQuery(updateReimb);
				
				
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
		} finally {
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
			}
			cf.releaseConnection(conn);
		}
		
		// return the original object but with any database generated fields filled out
		return c;
	}
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Reimbursement> u= allReimbursements();
		response.setStatus(200);
		
		response.getWriter().write(om.writeValueAsString(u));
		response.setHeader("Content-Type", "application/json");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReimbursementAction reimb = om.readValue(request.getInputStream(), ReimbursementAction.class);
		if(reimb.getAction().equals("filter")) {
			List<Reimbursement> u= allReimbursements(reimb.getStatusId());
			response.setStatus(200);
			//user u = login(reimb.getusername, reimb.getpassword
			response.getWriter().write(om.writeValueAsString(u));
			response.setHeader("Content-Type", "application/json");
			
		}
		else if(reimb.getAction().equals("nofilter")) {
			List<Reimbursement> u= allReimbursements();
			response.setStatus(200);
			
			response.getWriter().write(om.writeValueAsString(u));
			response.setHeader("Content-Type", "application/json");
			
		}
		else if(reimb.getAction().equals("update")) {
			Reimbursement u= updateReimbursement(reimb.getStatusId(),reimb.getReimb_id());
			response.setStatus(200);
			
			response.getWriter().write(om.writeValueAsString(u));
			response.setHeader("Content-Type", "application/json");
		}
		else {
			response.setStatus(200);
			response.getWriter().write("No result found");
		}
		
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementAction reimb = om.readValue(request.getInputStream(), ReimbursementAction.class);
		if(reimb.getAction().equals("update")) {
			Reimbursement u= updateReimbursement(reimb.getStatusId(),reimb.getReimb_id());
			response.setStatus(200);
			
			response.getWriter().write(om.writeValueAsString(u));
			response.setHeader("Content-Type", "application/json");
		}
		else {
			response.setStatus(200);
			response.getWriter().write("No result found");
		}
	}
	
	

}