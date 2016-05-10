package com.mycompany.shoppingCart.bo;

public class User {
	private int userId;
	private String userName;
	private String pass;
	private String email;

	public User(String userName, String pass, String email) {
		this.userName = userName;
		this.pass = pass;
		this.email = email;
	}
	
	public User() {		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
