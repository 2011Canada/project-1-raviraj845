package com.revature.models;

public class EmployeeAction {
	
	
	private String empAction;
	private int ers_users_id;
	private double amount;
	private String description;
	private int typeId;
	public String getEmpAction() {
		return empAction;
	}
	public void setEmpAction(String empAction) {
		this.empAction = empAction;
	}
	public int getErs_users_id() {
		return ers_users_id;
	}
	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public EmployeeAction(String empAction, int ers_users_id, double amount, String description, int typeId) {
		super();
		this.empAction = empAction;
		this.ers_users_id = ers_users_id;
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
	}
	public EmployeeAction() {
		super();
	}
	
	
	
	

}
