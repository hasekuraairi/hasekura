package com.example.demo;

public class LoginForm {

	private String loginID;

	private String password;

	public String getLoginID() {
		return this.loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Person(LoginID: " + this.loginID + ", Password: " + this.password + ")";
	}
}