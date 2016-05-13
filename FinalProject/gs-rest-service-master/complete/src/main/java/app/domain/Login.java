package app.domain;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Login entity", description = "User and password to login")
public class Login {

	@ApiModelProperty(value = "The username to login")
	private String userName;

	@ApiModelProperty(value = "The password of the corresponding username")
	private String pass;

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
}
