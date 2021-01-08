package com.revature.models;

public class ReimbursementAction {
	
	
	private String action;

	private int typeId;
	
	private int statusId;
	
	private int reimb_id;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public ReimbursementAction() {
		super();
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public ReimbursementAction(String action, int typeId, int statusId, int reimb_id) {
		super();
		this.action = action;
		this.typeId = typeId;
		this.statusId = statusId;
		this.reimb_id = reimb_id;
	}
	
	
	

}
