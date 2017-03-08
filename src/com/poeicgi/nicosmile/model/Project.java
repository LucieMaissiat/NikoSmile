package com.poeicgi.nicosmile.model;

import java.util.ArrayList;
import java.util.Date;

import com.poeicgi.nicosmile.model.base.ModelBase;

public class Project extends ModelBase{
	public static final String TABLE = "projet";
	
	private String name;
	private Date startDate;
	private Date endDate;
	private ArrayList<User> team;
	private ArrayList<NikoNiko> nikos;
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
	public ArrayList<User> getTeam() {
		return team;
	}
	public void setTeams(ArrayList<User> team) {
		this.team = team;
	}
	public ArrayList<NikoNiko> getNikos() {
		return nikos;
	}
	public void setNikos(ArrayList<NikoNiko> nikos) {
		this.nikos = nikos;
	}
	public Project(String name, ArrayList<User> team) {
		super();
		this.name = name;
		this.startDate = new Date();
		this.team = team;
		for (User user : team) {
			user.getProjects().add(this);
		}
		this.nikos = new ArrayList<NikoNiko>();
	}
	
	
	
	

}
