package app.domain;

public class User {
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

	@Override
	public String toString() {
		return "User [user=" + userName + ", password=" + pass + ", email=" + email + "]";
	}
}
