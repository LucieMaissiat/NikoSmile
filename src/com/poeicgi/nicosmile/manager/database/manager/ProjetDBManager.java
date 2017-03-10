package com.poeicgi.nicosmile.manager.database.manager;

import java.util.ArrayList;

import com.poeicgi.nicosmile.manager.database.manager.base.BaseDBManager;
import com.poeicgi.nicosmile.model.NikoNiko;
import com.poeicgi.nicosmile.model.Project;

public class ProjetDBManager extends BaseDBManager<Project> {

	@Override
	public void purgeTable(String table) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Project> getAll() {
		ProjetDBManager project = new ProjetDBManager();
		return project.getAll(Project.class);
	}

	@Override
	public void update(Project item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Project item) {
		// TODO Auto-generated method stub

	}

	@Override
	public <O> void mapRelation(Project item, O relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateWithChildren(Project item) {
		// TODO Auto-generated method stub

	}

	@Override
	public <O> void updateChildren(Project item, O sampleChild) {
		// TODO Auto-generated method stub

	}
}

