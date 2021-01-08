package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.util.ConnectionFactory;
import com.revature.models.EmployeeAction;
import com.revature.models.Reimbursement;

public class EmployeeServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	ObjectMapper om = new ObjectMapper();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<Reimbursement> allReimbursements1(int userId){
    	Connection conn = this.cf.getConnection();
		
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		try {
			String sql ="select e.reimb_id,e.reimb_amount,e.reimb_description,"
					+ "e.reimb_submitted,e.reimb_resolved,"
					+ "e.reimb_resolver,ers_reimbursement_status.reimb_status,ers_reimbursement_type.reimb_type,"
					+ "ers_users.user_first_name,ers_users.user_last_name "
					+ "FROM \"ERS\".ers_reimbursement e\r\n"
					+ "INNER JOIN \"ERS\".ers_reimbursement_status ON e.reimb_status_id = ers_reimbursement_status.reimb_status_id\r\n"
					+ "INNER JOIN \"ERS\".ers_reimbursement_type ON e.reimb_type_id = ers_reimbursement_type.reimb_type_id\r\n"
					+ "INNER JOIN \"ERS\".ers_users on e.reimb_author = ers_users.ers_users_id " 
					+ "WHERE ers_users.ers_users_id=" + userId +";"; 
			
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
    
    
    /*public List<Reimbursement> allReimbursements(int input){
    	Connection conn = this.cf.getConnection();
		
		List<Reimbursement> all = new ArrayList<Reimbursement>();
		try {
			String sql = "select e.reimb_id,e.reimb_amount,e.reimb_description,"
					+ "e.reimb_submitted,e.reimb_resolved,"
					+ "e.reimb_resolver,"
					+ "ers_users.user_first_name,ers_users.user_last_name"
					+ "FROM \"ExpenseSystem\".ers_reimbursement e"					
					+ "INNER JOIN \"ExpenseSystem\".ers_users on e.reimb_author = ers_users.ers_users_id  where \"reimb_type_id\"= " + input + ";";
			
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);
			
			
			while (res.next()) {
				Reimbursement c = new Reimbursement();
				c.setReimb_id(res.getInt("reimb_id"));
				c.setUser_first_name(res.getString("user_first_name"));
				c.setUser_last_name(res.getString("user_last_name"));
				c.setReimb_amount(res.getDouble("reimb_amount"));
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
				c.setReimb_description(res.getString("reimb_description"));
				all.add(c);
			}
		} catch (SQLException e) {
			
		} finally {
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
    return all;
    }
    */
    
    public Reimbursement newReimb(int ers_users_id, double amount,String description, int typeId) {
		Connection conn = cf.getConnection();
		Reimbursement r = new Reimbursement();
		try {
			conn.setAutoCommit(false);
				String newReimb = "Insert into \"ERS\".\"ers_reimbursement\" (\"reimb_amount\",\"reimb_submitted\",\"reimb_description\",\"reimb_author\",\"reimb_resolver\",\"reimb_status_id\",\"reimb_type_id\") "+
						"values( ?, ?, ?, ?, ?, ?, ?) returning \"reimb_id\";";
				PreparedStatement insertReimb = conn.prepareStatement(newReimb);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				insertReimb.setDouble(1, amount);
				insertReimb.setTimestamp(2, timestamp);
				
				insertReimb.setString(3, description);
				
				insertReimb.setInt(4, ers_users_id);
				insertReimb.setInt(5, 4);
				insertReimb.setInt(6, 2);
				insertReimb.setInt(7, typeId);
				insertReimb.executeQuery();
		} catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				
			}
			cf.releaseConnection(conn);
		}
		return r;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeAction emp = om.readValue(request.getInputStream(), EmployeeAction.class);
		 if(emp.getEmpAction().equals("ins")) {
			Reimbursement r= newReimb(emp.getErs_users_id(), emp.getAmount(),emp.getDescription(), emp.getTypeId());
			response.setStatus(200);
			
			response.getWriter().write(om.writeValueAsString(r));
			response.setHeader("Content-Type", "application/json");
			
		}else if(emp.getEmpAction().equals("disp")) {
			List<Reimbursement> r= allReimbursements1(emp.getErs_users_id());
			response.setStatus(200);
			
			response.getWriter().write(om.writeValueAsString(r));
			response.setHeader("Content-Type", "application/json");
			
		}
		else {
			response.setStatus(200);
			response.getWriter().write("No result found");
		}
	}
	
	
	

}
