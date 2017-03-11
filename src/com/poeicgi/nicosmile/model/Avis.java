package com.poeicgi.nicosmile.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.poeicgi.nicosmile.model.modelbase.DataBaseItem;
import com.poeicgi.nicosmile.utils.Fonction;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.model.User;
import com.poeicgi.nicosmile.utils.mysql.MySQLAnnotation;
import com.poeicgi.nicosmile.utils.mysql.MySQLTypes;

public class Avis extends DataBaseItem {
	
	public static final String TABLE = "avis";
	public static final String[] FIELDS = { "id", "avis_journee", "date_jour", "texte_jour", "date_modif",
			"is_anonymous", "id_utilisateur", "id_project" };
	
	
	@MySQLAnnotation(fieldName = "satisfaction", mysqlType = MySQLTypes.INT)
	private int satisfaction;
	
	@MySQLAnnotation(fieldName = "log_Date", mysqlType = MySQLTypes.DATETIME)
	private Date logDate;
	
	@MySQLAnnotation(fieldName = "nikoniko_comment", mysqlType = MySQLTypes.TEXT, nullable = true)
	private String commentSat;
	
	@MySQLAnnotation(fieldName = "change_Date", mysqlType = MySQLTypes.DATETIME, nullable = true)
	private ArrayList<Date> changeDates;
	
	@MySQLAnnotation(fieldName = "isanonymous", mysqlType = MySQLTypes.TINYINT)
	private Boolean isAnonymous;
	
	@MySQLAnnotation(fieldName = "id_User",mysqlType = MySQLTypes.DATABASE_ITEM, nullable = true)
	private User user;
	
	@MySQLAnnotation(fieldName = "id_Project",mysqlType = MySQLTypes.DATABASE_ITEM, nullable = true)
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
	
	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Avis(String logDate, int satisfaction, User user) {
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
		user.getAvis().add(this);
	}
	
	public Avis(int satisfaction, String commentSat) {
		super();
		this.logDate= new Date();
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
		this.commentSat = commentSat;
	}
	
	public Avis(int satisfaction) {
		super();
		this.logDate= new Date();
		if (Fonction.nikoCheck(satisfaction)){
			this.satisfaction = satisfaction;
		}else {
			this.satisfaction = 0;
		}
	}
	
	public Avis(User user, Project project, int satisfaction) {
		this();
		this.user = user;
		this.project = project;
		this.setSatisfaction(satisfaction);
		this.logDate = new Date();
		this.user.getAvis().add(this);
	}

	public Avis(User user, Project project, int satisfaction, String comment) {
		this(user, project, satisfaction);
		this.commentSat = comment;
	}

	public Avis(User user, Project project, int satisfaction, Boolean isAnonymous) {
		this(user, project, satisfaction);
		this.isAnonymous = isAnonymous;
	}

	public Avis(User user, Project project, int satisfaction,
			String comment, Boolean isAnonymous) {
		this(user, project, satisfaction);
		this.commentSat = comment;
		this.isAnonymous = isAnonymous;
	}

	public Avis() {
		super(Avis.TABLE, Avis.FIELDS);
	}

	@Override
	public String toString() {
		return "Avis [log_date=" + logDate + ", change_date="
				+ changeDates + ", satisfaction=" + satisfaction + ", comment="
				+ commentSat + ", isAnonymous=" + isAnonymous + "]";
	}

}
