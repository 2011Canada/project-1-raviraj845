package com.revature.models;

public class UserRoles {
	
	private int ers_user_role_id;
	private int ers_user_role;
	public int getErs_user_role_id() {
		return ers_user_role_id;
	}
	public void setErs_user_role_id(int ers_user_role_id) {
		this.ers_user_role_id = ers_user_role_id;
	}
	public int getErs_user_role() {
		return ers_user_role;
	}
	public void setErs_user_role(int ers_user_role) {
		this.ers_user_role = ers_user_role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ers_user_role;
		result = prime * result + ers_user_role_id;
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
		UserRoles other = (UserRoles) obj;
		if (ers_user_role != other.ers_user_role)
			return false;
		if (ers_user_role_id != other.ers_user_role_id)
			return false;
		return true;
	}
	public UserRoles(int ers_user_role_id, int ers_user_role) {
		super();
		this.ers_user_role_id = ers_user_role_id;
		this.ers_user_role = ers_user_role;
	}
	@Override
	public String toString() {
		return "UserRoles [ers_user_role_id=" + ers_user_role_id + ", ers_user_role=" + ers_user_role + "]";
	}
	public UserRoles() {
		super();
	}
	
	
	
	
	

}
