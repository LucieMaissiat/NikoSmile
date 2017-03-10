package com.poeicgi.nicosmile.model.modelbase;

import com.tactfactory.nikoniko.utils.mysql.MySQLAnnotation;
import com.tactfactory.nikoniko.utils.mysql.MySQLTypes;

public abstract class DataBaseItem {

	public String table;
	public String[] fields;

	@MySQLAnnotation(fieldName = "id", mysqlType = MySQLTypes.INT)
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		if (id>0){
			this.id = id;
		}else {
			this.id = 0;
		}
		
	}

	public DataBaseItem(String table, String[] fields) {
		this.table = table;
		this.fields = fields;
	}

	public DataBaseItem() {
	}
}
