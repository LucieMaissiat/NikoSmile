package com.poeicgi.nicosmile.database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.poeicgi.nicosmile.database.MySQLAccess;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.model.User;
import com.poeicgi.nicosmile.utils.DateConverter;


public class ProjetDBManager {
	
	public String getProjectValues (Project project){
		String query = "";
		
		if (project.getId() != 0) {
			query += project.getId() + ", ";
		}else {
			query += "null, ";
		}

		query += "'"+ project.getName() + "', ";
		query += "'"+DateConverter.getMySQLDateTime(project.getStartDate())+ "', ";
		
		if (project.getEndDate()!=null) {
			query += "'"+DateConverter.getMySQLDateTime(project.getEndDate()) + "'";
		}else {
			query += "null";
		}
		
		
		return query;
	}
	
	public void insert(Project project){
		
		String query = "";
		query += "INSERT INTO "+ Project.TABLE +" VALUES (";
		query += this.getProjectValues(project);
		query += ")";
		
		
		MySQLAccess.getInstance().updateQuery(query);
		
		if(project.getId()==0){
			ResultSet result = MySQLAccess.getInstance().resultQuery(
					"SELECT MAX(id) AS id FROM "+ Project.TABLE);
			try{
				if(result.next()){
					project.setId(result.getInt(1));
				}
			}catch (SQLException e1){
				e1.printStackTrace();
			}
		}
	}
	
	public void insertUsers (Project project){
		UserDBManager manager = new UserDBManager();
		for (User user : project.getTeam()) {
			manager.insert(user);
			this.insertRelationTeam(user,project);
		}
	}
	
	public void insertRelationTeam(User user, Project project){
		String query = "";
		
		query = "INSERT INTO "+ "equipe" + "VALUES (";
		query = project.getId() + ", ";
		query = user.getId() + ")";
		
		MySQLAccess.getInstance().updateQuery(query);
		
	}
}
