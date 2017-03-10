package com.poeicgi.nicosmile.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import com.poeicgi.nicosmile.config.Configuration;

public class MySQLAccess {
	private Connection connect = null;

	/** Constructeur prive */
	private MySQLAccess() {
		try {
			connectDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** Instance unique pre-initialisee */
	private static MySQLAccess INSTANCE = new MySQLAccess();

	/** Point d'acces pour l'instance unique du singleton */
	public static MySQLAccess getInstance() {
		return INSTANCE;
	}

	private void connectDataBase() throws Exception {
		// This will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		Map<String, String> map = Configuration.getInstance().getMap();
		String user = map.get("user");
		String password = map.get("password");
		String driver = map.get("db_driver");
		String host = map.get("db_host");
		String database = map.get("db_name");

		String url = String.format(
		        "jdbc:%s://%s/%s?user=%s&password=%s",
		        driver, host, database, user, password
        );

		connect = DriverManager.getConnection(url);
	}

	public ResultSet resultQuery(String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		try {

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery(query);
			return resultSet;
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}

	public void updateQuery(String query) {
		int result = 0;
		Statement statement = null;
		try {

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			result = statement.executeUpdate(query);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}