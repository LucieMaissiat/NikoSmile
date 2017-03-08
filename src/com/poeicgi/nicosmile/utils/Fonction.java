package com.poeicgi.nicosmile.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.poeicgi.nicosmile.database.MySQLAccess;
import com.poeicgi.nicosmile.model.NikoNiko;
import com.poeicgi.nicosmile.model.User;

public abstract class Fonction {

	public static void printNikosUser(User user) {
		for (NikoNiko niko : user.getNikos()) {
			ArrayList<Integer> test = new ArrayList<Integer>();
			test.add(1);
			test.add(0);
			test.add(-1);
			if (test.contains(niko.getSatisfaction())){
				System.out.println(niko.getSatisfaction());
			}
			
		}
	}
	
	public static boolean nikoCheck(int intgiven) {
	
			ArrayList<Integer> test = new ArrayList<Integer>();
			test.add(1);
			test.add(0);
			test.add(-1);
			if (test.contains(intgiven)){
				return true;
			}else{
				return false;
			}
			
		
	}
	
	public static void printStatNikosUser(User user){
		float moyenne=0;
		int countNikos=0;
		for (NikoNiko niko : user.getNikos()) {
			
			moyenne=moyenne + niko.getSatisfaction();
			countNikos++;
			
		}
		moyenne = Math.round(moyenne / countNikos);
		
		
		System.out.println(moyenne);
	}
	
	public static void readNikoConsole(){
		BufferedReader br = null;
		MySQLAccess instance = MySQLAccess.getInstance();
		while(true){
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.println("Enter your satisfaction : ");
				String input;
				
				input = br.readLine();
				
				if ("q".equals(input)) {
					break;
				}
				
				if(Fonction.nikoCheck(Integer.parseInt(input))){
					
					
					System.out.print("Comment ? : ");
					String input1 = br.readLine();
					if (!input1.equals("")){
						
						NikoNiko tempNiko = new NikoNiko( Integer.parseInt(input), input1);
						String update = "INSERT INTO avis (avis_journee,texte_jour, is_anonymous) VALUES (" + tempNiko.getSatisfaction() + ", \"" + tempNiko.getCommentSat() + "\");" ; 
						instance.updateQuery(update);
					}else {
						NikoNiko tempNiko = new NikoNiko(Integer.parseInt(input));
						String update = "INSERT INTO avis (avis_journee,  is_anonymous) VALUES (" + tempNiko.getSatisfaction() + ");" ; 
						instance.updateQuery(update);
					}
					
				}else {
					System.err.println("Input issue.");
				}
				
				System.out.println("input : "+ input);
				System.out.println("---------\n");
				
			}
			catch (IOException e){
				e.printStackTrace();
			}	
		}
	}
		
	public static void printSELECT (String select) {
		MySQLAccess instance =MySQLAccess.getInstance();
		
		ResultSet rs = instance.resultQuery(select);
		   java.sql.ResultSetMetaData rsmd = null;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   System.out.println("querying " +select );
		   int columnsNumber = 0;
		try {
			columnsNumber = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		   try {
			while (rs.next()) {
			       for (int i = 1; i <= columnsNumber; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = rs.getString(i);
			           System.out.print(columnValue + " " + rsmd.getColumnName(i));
			       }
			       System.out.println("");
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
