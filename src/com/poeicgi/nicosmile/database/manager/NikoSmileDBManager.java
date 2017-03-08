package com.poeicgi.nicosmile.database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.poeicgi.nicosmile.database.MySQLAccess;
import com.poeicgi.nicosmile.model.NikoNiko;
import com.poeicgi.nicosmile.model.User;
import com.poeicgi.nicosmile.utils.DateConverter;

public class NikoSmileDBManager {
	
	public String getNikoNikoValues (NikoNiko nikoniko){
		String query = "";
		
		if (nikoniko.getId() != 0) {
			query += nikoniko.getId() + ", ";
		}else {
			query += "null, ";
		}

		query += nikoniko.getSatisfaction() + ", ";
		query += "'"+DateConverter.getMySQLDateTime(nikoniko.getLogDate()) + "', ";
		
		if (nikoniko.getCommentSat()!=null) {
			query += "'"+nikoniko.getCommentSat() + "', ";
		}else {
			query += "null, ";
		}
		
		if (nikoniko.getChangeDate()!=null) {
			query += "'"+DateConverter.getMySQLDateTime(nikoniko.getChangeDate()) + "', ";
		}else {
			query += "null, ";
		}
		
		query += nikoniko.getIsAnonymous() + ", ";
		
		if (nikoniko.getUser() != null && nikoniko.getUser().getId()!=0) {
			query += nikoniko.getUser().getId() + ", ";
		}else {
			query += "null, ";
		}
		
		if (nikoniko.getProject() != null && nikoniko.getProject().getId()!=0) {
			query += nikoniko.getProject().getId() ;
		}else {
			query += "null";
		}
		
		return query;
	}
	
	public void insert(NikoNiko nikoniko){
		
		String query = "";
		query += "INSERT INTO avis VALUES (";
		query += this.getNikoNikoValues(nikoniko);
		query += ")";
		
		
		MySQLAccess.getInstance().updateQuery(query);
		
		if(nikoniko.getId()==0){
			ResultSet result = MySQLAccess.getInstance().resultQuery(
					"SELECT MAX(id) AS id FROM "+ NikoNiko.TABLE);
			try{
				if(result.next()){
					nikoniko.setId(result.getInt(1));
				}
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
	}

	
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
	
	public void insertUser(User user){
		
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
	}
}
