package com.revature.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.AllReimbursement;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	
	public List<AllReimbursement> allReimbursements(){
    	Connection conn = this.cf.getConnection();
		
		List<AllReimbursement> all = new ArrayList<AllReimbursement>();
		try {
			String sql = "select  REIMB_ID,REIMB_AMOUNT,REIM_SUBMITTED,REIM_RESOLVED,REIM_DESCRIPTION,FIRST_NAME,LAST_NAME\r\n" + 
					"\r\n" + 
					"from ers_reimbursement inner join ERS_USERS on REIMB_AUTHOR=ERS_USERS_ID;";
			
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);
			
			
			while (res.next()) {
				AllReimbursement c = new AllReimbursement();
				c.setReimbId(res.getInt("reimb_id"));
				c.setAmount(res.getDouble("reimb_amount"));
				c.setSubmitted(res.getTimestamp("reim_submitted"));
				c.setResolved(res.getTimestamp("reim_resolved"));
				c.setDescription(res.getString("reim_description"));
				c.setFirstname(res.getString("first_name"));
				c.setLastname(res.getString("last_name"));
				all.add(c);
			}
		} catch (SQLException e) {
			
		} finally {
			// if we actually had a pool of connections, we would do this
			cf.releaseConnection(conn);
		}
    return all;

}
	
}

	
	
	
	
