package com.revature.models;

public class ReimbursementStatus {
	
	
	private int reimb_status_id;
	private int reimb_status;
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public int getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(int reimb_status) {
		this.reimb_status = reimb_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimb_status;
		result = prime * result + reimb_status_id;
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimb_status != other.reimb_status)
			return false;
		if (reimb_status_id != other.reimb_status_id)
			return false;
		return true;
	}
	public ReimbursementStatus(int reimb_status_id, int reimb_status) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}
	public ReimbursementStatus() {
		super();
	}
	
	
		
	

}
