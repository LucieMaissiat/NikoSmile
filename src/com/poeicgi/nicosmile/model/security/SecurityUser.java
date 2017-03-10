package com.poeicgi.nicosmile.model.security;

import com.poeicgi.nicosmile.model.modelbase.DataBaseItem;
import com.tactfactory.nikoniko.utils.mysql.MySQLAnnotation;
import com.tactfactory.nikoniko.utils.mysql.MySQLTypes;

public class SecurityUser extends DataBaseItem {

	@MySQLAnnotation(fieldName = "login", mysqlType = MySQLTypes.VARCHAR)
	private String login;

	@MySQLAnnotation(fieldName = "password", mysqlType = MySQLTypes.VARCHAR)
	private String password;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public SecurityUser(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public SecurityUser(String table, String[] fields) {
		super(table, fields);
	}
}
