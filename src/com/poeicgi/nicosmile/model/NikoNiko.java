package com.poeicgi.nicosmile.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.poeicgi.nicosmile.model.base.ModelBase;

public class NikoNiko extends ModelBase {
	public static final String TABLE = "avis";
	
	private Date logDate;
	private Date changeDate;
	private int satisfaction;
	private String commentSat;
	private Boolean isAnonymous;
	private User user;
	private Project project;
	
	
	public Date getLogDate() {
		if (this.logDate==null) {
			this.logDate= new Date();
		}
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(int satisfaction) {
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
		
	}
	public String getCommentSat() {
		return commentSat;
	}
	public void setCommentSat(String comment) {
		this.commentSat = comment;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public NikoNiko(String logDate, int satisfaction, Boolean isAnonymous, User user, Project project) {
		super();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			this.logDate = format.parse(logDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
		this.isAnonymous = isAnonymous;
		this.user = user;
		user.getNikos().add(this);
		this.project = project;
		project.getNikos().add(this);
	}
	public NikoNiko(int satisfaction, String commentSat) {
		super();
		this.logDate= new Date();
		this.isAnonymous= true;
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
		this.commentSat = commentSat;
	}
	
	public NikoNiko(int satisfaction) {
		super();
		this.logDate= new Date();
		this.isAnonymous= true;
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
	}
	public NikoNiko() {
		
	}
	
	
	

}
