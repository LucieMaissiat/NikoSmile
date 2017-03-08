package com.poeicgi.nicosmile.model;

import java.util.ArrayList;

import com.poeicgi.nicosmile.model.base.Security;

public class User extends Security{
	
	public static final String TABLE = "utilisateur";
	
	private String lastName;
	private String firstName;
	private String registrationCGI;
	private ArrayList<Project> projects;
	private ArrayList<NikoNiko> nikos;
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getRegistrationCGI() {
		return registrationCGI;
	}
	
	public void setRegistrationCGI(String registrationCGI) {
		this.registrationCGI = registrationCGI;
	}
	
	public ArrayList<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	public ArrayList<NikoNiko> getNikos() {
		return nikos;
	}
	
	public void setNikos(ArrayList<NikoNiko> nikos) {
		this.nikos = nikos;
	}
	
	public User( String lastName, String firstName, String registrationCGI,String login, String password) {
		super(login, password);
		this.lastName = lastName;
		this.firstName = firstName;
		this.registrationCGI = registrationCGI;
		this.projects = new ArrayList<Project>();
		this.nikos = new ArrayList<NikoNiko>();
	}

	
	

}
