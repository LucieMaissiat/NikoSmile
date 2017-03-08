package com.poeicgi.nicosmile.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	
	public static String getMySQLDate(Date date){
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}else {
			return null;
		}
		
		
		
	}
	
	public static String getMySQLDateTime(Date date){
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}else {
			return null;
		}
		
	}

}
