package com.revature.muhammad_p1.models;

public class Users {

	private int id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String role;
	private int roleId;

	
	public Users(int id, String username, String password, String first_name, String last_name, String email,
			int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String username) {
		super();
		
		this.username = username;
	}
	
	public Users(String username, String role) {
		super();
		
		this.username = username;
		this.role = role;
	}
	
	
	
	public Users(int id, String username, String first_name, String last_name, String email,
			String role) {
		super();
		this.id = id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}

	public Users(String username, String password, String first_name, String last_name, String email, String role) {
		super();
		
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}

	public Users(String username, String first_name, String last_name, String email, String role) {
		super();
		
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}

//	public Users(String username, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//	}
	
	

	public Users(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Users(String first_name, String last_name, String email, String role) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", role=" + role + ", roleId=" + roleId + "]";
	}

	public Users(int id, String username, String password, String first_name, String last_name, String email,
			String role, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
		this.roleId = roleId;
	}



	


	
	
	
	
}
