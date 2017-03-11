package com.poeicgi.nicosmile.model;

import java.util.ArrayList;

import com.poeicgi.nicosmile.model.security.SecurityUser;
import com.poeicgi.nicosmile.model.Avis;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.utils.mysql.MySQLAnnotation;
import com.poeicgi.nicosmile.utils.mysql.MySQLTypes;
import com.poeicgi.nicosmile.model.Avis;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.model.Avis;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.model.User;

public class User extends SecurityUser{
	
	public static final String TABLE = "utilisateur";

	public static final String[] FIELDS = { "id", "nom", "prenom", "matricule_CGI", "verticale", "Agence",
			"id_securite" };
	
	@MySQLAnnotation(fieldName = "nom", mysqlType = MySQLTypes.VARCHAR)
	private String lastName;
	
	@MySQLAnnotation(fieldName = "prenom", mysqlType = MySQLTypes.VARCHAR)
	private String firstName;
	
	@MySQLAnnotation(fieldName = "matricule_CGI", mysqlType = MySQLTypes.VARCHAR)
	private String registrationCGI;
	
	@MySQLAnnotation(fieldName = "verticale", mysqlType = MySQLTypes.VARCHAR)
	private String verticale;
	
	@MySQLAnnotation(fieldName = "Agence", mysqlType = MySQLTypes.VARCHAR)	
	private String agency;
	
	@MySQLAnnotation(fieldName = "id_utilisateur", mysqlType = MySQLTypes.ASSOCIATION,
			associationTable = "avis", nullable = true)
	private ArrayList<Avis> avis;
	
	@MySQLAnnotation(fieldName = "id_utilisateur", mysqlType = MySQLTypes.ASSOCIATION,
			associationTable = "equipe", nullable = true)
	private ArrayList<Project> projects;
	
	@MySQLAnnotation(fieldName = "id_User", mysqlType = MySQLTypes.ASSOCIATION,
			associationTable = "securite", nullable = true)
	private ArrayList<SecurityUser> securite;

	
	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	
	public String getVerticale() {
		return verticale;
	}

	public void setVerticale(String verticale) {
		this.verticale = verticale;
	}
	
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
	
	public ArrayList<Avis> getAvis() {
		return avis;
	}
	
	public void setAvis(ArrayList<Avis> avis) {
		this.avis = avis;
	}

	public User(String login, String password, String lastname, String firstname, String registration_cgi) {
		super(User.TABLE, User.FIELDS, login, password);
		this.lastName = lastname;
		this.firstName = firstname;
		this.registrationCGI = registrationCGI;
		this.projects = new ArrayList<Project>();
		this.avis = new ArrayList<Avis>();
	}
	
	public User() {
		super(User.TABLE, User.FIELDS);
		this.avis = new ArrayList<Avis>();
		this.projects = new ArrayList<Project>();
	}

}
