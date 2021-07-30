package com.ss.cfsd.utopia.domain;

public class User {

	private Integer id = null;
	private Integer roleId = null;
	private String givenName = null;
	private String familyName = null;
	private String username = null;
	private String email = null;
	private String password = null;
	private String phone = null;
	
	public Integer getId() {
		return id;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setRoleId(UserRole userRole) {
		roleId = userRole.getId();
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
