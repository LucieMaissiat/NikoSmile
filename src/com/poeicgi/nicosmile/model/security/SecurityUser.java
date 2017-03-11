package com.poeicgi.nicosmile.model.security;

import java.util.ArrayList;

import com.poeicgi.nicosmile.model.User;
import com.poeicgi.nicosmile.model.modelbase.DataBaseItem;
import com.poeicgi.nicosmile.utils.mysql.MySQLAnnotation;
import com.poeicgi.nicosmile.utils.mysql.MySQLTypes;
import com.poeicgi.nicosmile.model.modelbase.DataBaseItem;

public class SecurityUser extends DataBaseItem {

	@MySQLAnnotation(fieldName = "login", mysqlType = MySQLTypes.VARCHAR)
	private String login;

	@MySQLAnnotation(fieldName = "mot_de_passe", mysqlType = MySQLTypes.VARCHAR)
	private String password;

	@MySQLAnnotation(fieldName = "Statut", mysqlType = MySQLTypes.VARCHAR)
	private String status;
	
	@MySQLAnnotation(fieldName = "id_securite", mysqlType = MySQLTypes.ASSOCIATION,
			associationTable = "utilisateur", nullable = true)
	private ArrayList<User> user;
	
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

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public SecurityUser(String table, String[] fields, String login, String password) {
		super(table, fields);
		this.login = login;
		this.password = password;
	}

	public SecurityUser(String table, String[] fields) {
		super(table, fields);
	}
}

