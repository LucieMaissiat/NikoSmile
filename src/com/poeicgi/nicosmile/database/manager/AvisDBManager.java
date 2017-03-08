package com.poeicgi.nicosmile.database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.poeicgi.nicosmile.database.MySQLAccess;
import com.poeicgi.nicosmile.model.NikoNiko;
import com.poeicgi.nicosmile.utils.DateConverter;

public class AvisDBManager {
	
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

}

