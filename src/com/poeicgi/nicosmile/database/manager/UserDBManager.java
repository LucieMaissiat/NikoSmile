package com.poeicgi.nicosmile.database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.poeicgi.nicosmile.database.MySQLAccess;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.model.User;

public class UserDBManager {
	
	
	
	public String getUserValues (User user){
		String query = "";

		if (user.getLastName()!=null) {
			query += "'" +user.getLastName() + "', ";
		}else {
			query += "null, ";
		}
		
		if (user.getFirstName()!=null) {
			query += "'" +user.getFirstName() + "', ";
		}else {
			query += "null, ";
		}
		
		if (user.getRegistrationCGI()!=null) {
			query += "'" +user.getRegistrationCGI() + "'";
		}else {
			query += "null";
		}
		
		return query;
	}
	
	public String getSecurityValues (User user){
		String query = "";
		
		if (user.getId() != 0) {
			query += user.getId() + ", ";
		}else {
			query += "null, ";
		}

		if (user.getLogin()!=null) {
			query += "'" +user.getLogin() + "', ";
		}else {
			query += "null, ";
		}
		
		if (user.getPassword()!=null) {
			query += "'" +user.getPassword() + "', ";
		}else {
			query += "null, ";
		}
		
		
		return query;
	}
	
	public int getSecuId (String login, String pswd) {
		MySQLAccess instance =MySQLAccess.getInstance();
		String select ="Select id from securite WHERE login='"+login+"' AND mot_de_passe='"+pswd+"';";
		ResultSet rs = instance.resultQuery(select);
		int columnValue=0;
		  try {
			while (rs.next()) {
			       
			           columnValue = Integer.parseInt(rs.getString(1));
			       }	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnValue;
	}
	
	public void insert(User user){
		
		String querySecu = "";
		querySecu += "INSERT INTO securite VALUES (";
		querySecu += this.getSecurityValues(user);
		querySecu += "null,null)";
		
		MySQLAccess.getInstance().updateQuery(querySecu);
		int id =this.getSecuId(user.getLogin(), user.getPassword());
		
		String queryUser = "";
		queryUser += "INSERT INTO utilisateur VALUES ("+id+",";
		queryUser += this.getUserValues(user);
	
			queryUser += ",null,null,"+id+")";
		
		MySQLAccess.getInstance().updateQuery(queryUser);
		
		String query= "UPDATE securite SET id_utilisateur = "+id+" WHERE id= "+id+";";
		MySQLAccess.getInstance().updateQuery(query);
		
		if(user.getId()==0){
			ResultSet result = MySQLAccess.getInstance().resultQuery(
					"SELECT MAX(id) AS id FROM "+ User.TABLE);
			try{
				if(result.next()){
					user.setId(result.getInt(1));
				}
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
	}
	
	public void insertProject (User user){
		ProjetDBManager manager = new ProjetDBManager();
		for (Project project: user.getProjects()) {
			manager.insert(project);
			this.insertRelationProject(user,project);
		}
	}
	
	public void insertRelationProject(User user, Project project){
		String query = "";
		
		query = "INSERT INTO "+ "equipe" + "VALUES (";
		query = project.getId() + ", ";
		query = user.getId() + ")";
		
		MySQLAccess.getInstance().updateQuery(query);
		
	}
}
