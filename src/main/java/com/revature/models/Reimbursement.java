package com.revature.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Reimbursement {
	
private int reimb_id ;
	
	private String user_first_name;
	private String user_last_name;
	
	private double reimb_amount ;
	
	private Timestamp reimb_submitted ;
	
	private String ts;
	private String rs;
	
	
	private Timestamp reimb_resolved ;
	
	private Byte reimb_receipt ;
	
	private String reimb_description ;
	
	private int reimb_author ;
	private int reimb_resolver ;
	private int reimb_status_id ;
	private int reimb_type_id ;
	
	private Date ers_submitted ;
	//private Timestamp reimb_resolved ;
	
	private String reimb_status;

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public Byte getReimb_receipt() {
		return reimb_receipt;
	}

	public void setReimb_receipt(Byte reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public Date getErs_submitted() {
		return ers_submitted;
	}

	public void setErs_submitted(Date ers_submitted) {
		this.ers_submitted = ers_submitted;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ers_submitted == null) ? 0 : ers_submitted.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimb_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimb_author;
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
		result = prime * result + ((reimb_receipt == null) ? 0 : reimb_receipt.hashCode());
		result = prime * result + ((reimb_resolved == null) ? 0 : reimb_resolved.hashCode());
		result = prime * result + reimb_resolver;
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + reimb_status_id;
		result = prime * result + ((reimb_submitted == null) ? 0 : reimb_submitted.hashCode());
		result = prime * result + reimb_type_id;
		result = prime * result + ((rs == null) ? 0 : rs.hashCode());
		result = prime * result + ((ts == null) ? 0 : ts.hashCode());
		result = prime * result + ((user_first_name == null) ? 0 : user_first_name.hashCode());
		result = prime * result + ((user_last_name == null) ? 0 : user_last_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (ers_submitted == null) {
			if (other.ers_submitted != null)
				return false;
		} else if (!ers_submitted.equals(other.ers_submitted))
			return false;
		if (Double.doubleToLongBits(reimb_amount) != Double.doubleToLongBits(other.reimb_amount))
			return false;
		if (reimb_author != other.reimb_author)
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		if (reimb_receipt == null) {
			if (other.reimb_receipt != null)
				return false;
		} else if (!reimb_receipt.equals(other.reimb_receipt))
			return false;
		if (reimb_resolved == null) {
			if (other.reimb_resolved != null)
				return false;
		} else if (!reimb_resolved.equals(other.reimb_resolved))
			return false;
		if (reimb_resolver != other.reimb_resolver)
			return false;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_status_id != other.reimb_status_id)
			return false;
		if (reimb_submitted == null) {
			if (other.reimb_submitted != null)
				return false;
		} else if (!reimb_submitted.equals(other.reimb_submitted))
			return false;
		if (reimb_type_id != other.reimb_type_id)
			return false;
		if (rs == null) {
			if (other.rs != null)
				return false;
		} else if (!rs.equals(other.rs))
			return false;
		if (ts == null) {
			if (other.ts != null)
				return false;
		} else if (!ts.equals(other.ts))
			return false;
		if (user_first_name == null) {
			if (other.user_first_name != null)
				return false;
		} else if (!user_first_name.equals(other.user_first_name))
			return false;
		if (user_last_name == null) {
			if (other.user_last_name != null)
				return false;
		} else if (!user_last_name.equals(other.user_last_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", reimb_amount=" + reimb_amount + ", reimb_submitted=" + reimb_submitted + ", ts="
				+ ts + ", rs=" + rs + ", reimb_resolved=" + reimb_resolved + ", reimb_receipt=" + reimb_receipt
				+ ", reimb_description=" + reimb_description + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id=" + reimb_type_id
				+ ", ers_submitted=" + ers_submitted + ", reimb_status=" + reimb_status + "]";
	}

	public Reimbursement(int reimb_id, String user_first_name, String user_last_name, double reimb_amount,
			Timestamp reimb_submitted, String ts, String rs, Timestamp reimb_resolved, Byte reimb_receipt,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id,
			Date ers_submitted, String reimb_status) {
		super();
		this.reimb_id = reimb_id;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.ts = ts;
		this.rs = rs;
		this.reimb_resolved = reimb_resolved;
		this.reimb_receipt = reimb_receipt;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
		this.ers_submitted = ers_submitted;
		this.reimb_status = reimb_status;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


