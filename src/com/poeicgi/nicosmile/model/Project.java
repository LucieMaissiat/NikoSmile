package com.poeicgi.nicosmile.model;

import java.util.ArrayList;
import java.util.Date;

import com.poeicgi.nicosmile.model.base.ModelBase;

public class Project extends ModelBase{
	public static final String TABLE = "projet";
	
	private String name;
	private Date startDate;
	private Date endDate;
	private Boolean isAnonymous;
	private ArrayList<User> team;
	
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
	
		public Project(String name, ArrayList<User> team) {
		super();
		this.name = name;
		this.startDate = new Date();
		this.team = team;
		for (User user : team) {
			user.getProjects().add(this);
		}
	}
	
	
	
	

}
