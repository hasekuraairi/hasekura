package com.example.demo;

public class Account {

	private String name = "";
	private String uname = "";
	private String pass = "";

	public Account(String name, String uname, String pass) {
		this.name = name;
		this.uname = uname;
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return this.name;
	}

	public String getUname() {
		return this.uname;
	}

	public String getPass() {
		return this.pass;
	}

}
