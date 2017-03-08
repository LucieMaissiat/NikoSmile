package com.poeicgi.nicosmile.model.base;

public class Security extends ModelBase {
	private String login;
	private String password;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Security(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

}
