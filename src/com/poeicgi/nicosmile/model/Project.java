package com.poeicgi.nicosmile.model;

import java.util.ArrayList;
import java.util.Date;

import com.poeicgi.nicosmile.model.modelbase.DataBaseItem;
import com.poeicgi.nicosmile.utils.mysql.MySQLAnnotation;
import com.poeicgi.nicosmile.utils.mysql.MySQLTypes;

public class Project extends DataBaseItem{
	public static final String TABLE = "projet";
	public static final String[] FIELDS = { "id", "nom_projet", "Chef_de_projet", "verticale", "date_debut", "date_fin",
											"anonyme", "cache"};
	
	@MySQLAnnotation(fieldName = "nom_projet", mysqlType = MySQLTypes.VARCHAR)
	private String name;
	
	@MySQLAnnotation(fieldName = "Chef_de_projet", mysqlType = MySQLTypes.VARCHAR)
	private String projectLeader;
	
	@MySQLAnnotation(fieldName = "verticale", mysqlType = MySQLTypes.VARCHAR)
	private String verticale;
	
	@MySQLAnnotation(fieldName = "date_debut", mysqlType = MySQLTypes.DATETIME, nullable = true)
	private Date startDate;
	
	@MySQLAnnotation(fieldName = "date_fin", mysqlType = MySQLTypes.DATETIME, nullable = true)
	private Date endDate;
	
	@MySQLAnnotation(fieldName = "anonyme", mysqlType = MySQLTypes.BOOLEAN, nullable = true)
	private Boolean isAnonymous;
	
	@MySQLAnnotation(fieldName = "cache", mysqlType = MySQLTypes.BOOLEAN, nullable = true)
	private Boolean isHidden;
	
	private ArrayList<User> team;
	
	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public void setVerticale(String verticale) {
		this.verticale = verticale;
	}
	
	public String getVerticale() {
		return verticale;
	}

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getIsAnonymous() {
		if (this.isAnonymous==null) {
			this.isAnonymous=true;
		}
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public ArrayList<User> getTeam() {
		return team;
	}
	
	public void setTeam(ArrayList<User> team) {
		this.team = team;
	}
	
	public Project(String name, Date start_date) {
		super(Project.TABLE, Project.FIELDS);
		this.name = name;
		this.startDate = start_date;
		this.team = new ArrayList<User>();
		for (User user : team) {
			user.getProjects().add(this);
		}
	}
	
	public Project(String name, Date start_date, Date end_date) {
		super(Project.TABLE, Project.FIELDS);
		this.name = name;
		this.startDate = start_date;
		this.endDate = end_date;
		this.team = new ArrayList<User>();
		for (User user : team) {
			user.getProjects().add(this);
		}
	}

	public Project() {
		super(Project.TABLE, Project.FIELDS);
		this.team = new ArrayList<User>();
		for (User user : team) {
			user.getProjects().add(this);
	}

		
	}
	
	
	
	

}
