package com.poeicgi.nicosmile.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.poeicgi.nicosmile.model.modelbase.ModelBase;
import com.poeicgi.nicosmile.utils.Fonction;

public class NikoNiko extends ModelBase {
	
	public static final String TABLE = "avis";
	
	private Date logDate;
	private ArrayList<Date> changeDates;
	private int satisfaction;
	private String commentSat;
	private User user;
	
	public Date getLogDate() {
		if (this.logDate==null) {
			this.logDate= new Date();
		}
		return logDate;
	}
	
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
	public ArrayList<Date> getChangeDates() {
		return changeDates;
	}
	
	public void setChangeDates(ArrayList<Date> changeDates) {
		this.changeDates = changeDates;
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

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public NikoNiko(String logDate, int satisfaction, User user) {
		super();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			this.logDate = format.parse(logDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
		this.user = user;
		user.getNikos().add(this);
	}
	public NikoNiko(int satisfaction, String commentSat) {
		super();
		this.logDate= new Date();
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
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
	}
	public NikoNiko() {
		
	}
	
	
	

}
