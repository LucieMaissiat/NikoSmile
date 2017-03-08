package com.poeicgi.nicosmile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;
import com.poeicgi.nicosmile.database.MySQLAccess;
import com.poeicgi.nicosmile.database.manager.NikoSmileDBManager;
import com.poeicgi.nicosmile.model.Fonction;
import com.poeicgi.nicosmile.model.NikoNiko;
import com.poeicgi.nicosmile.model.Project;
import com.poeicgi.nicosmile.model.User;

public class Application {

	public static void main(String[] args) {
		
		User paulMachin = new User("Machin", "Paul","32F6785TH2","paul.machin","P@SSWRD");
		User jeanTruc = new User("Truc", "Jean","32H6755TM2","jean.truc","P@SSW0RD");
		ArrayList<User> membersProject1 = new ArrayList<User>();
		membersProject1.add(jeanTruc);
		membersProject1.add(paulMachin);
		Project project1 = new Project("Project1",membersProject1);
		NikoNiko nikoJeanDate1 = new NikoNiko("2017-02-15 18:30", 1, true, jeanTruc, project1);
		NikoNiko nikoJeanDate0 = new NikoNiko("2017-02-14 18:30", 1, true, jeanTruc, project1);
		NikoNiko nikoPaulDate1 = new NikoNiko("2017-02-15 18:30", 1, true, paulMachin, project1);
		NikoNiko nikoPaulDate0 = new NikoNiko("2017-02-14 18:30", 0, true, paulMachin, project1);

		/*Fonction.printNikosProject(project1);
		Fonction.printStatNikosProject(project1);
		
		Fonction.readNikoConsole();
		
		String select = "Select * from avis;";
		Fonction.printSELECT(select);
		
		
		
		NikoSmileDBManager manager = new NikoSmileDBManager();
		manager.insert(niko);
		
		niko.setCommentSat("jhg<FJ)fbjhgfjhvdjjGDFJjhdgvjhdfjvdhrg");
		manager.insert(niko);*/
		
		User user1 = new User("NomFamille", "Prénom","32R5685TH2","NomFamille.Prénom","P@SSWRD");
		User user2 = new User("NomFamille2", "Prénom2","32R5685TH3","NomFamille2.Prénom2","P@SSWRD2");
		User user3 = new User(null, null,null,"NomFamille3.Prénom3","P@SSWRD3");
		NikoSmileDBManager manager = new NikoSmileDBManager();
		manager.insertUser(user1);
		manager.insertUser(user2);
		manager.insertUser(user3);
		
		NikoNiko niko = new NikoNiko();
		niko.setSatisfaction(1);
		
	}

}
