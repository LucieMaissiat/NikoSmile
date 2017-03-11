package com.poeicgi.nicosmile.manager.database.manager;

import java.util.ArrayList;

import com.poeicgi.nicosmile.manager.database.manager.base.BaseDBManager;
import com.poeicgi.nicosmile.model.Avis;
import com.poeicgi.nicosmile.model.User;

public class UserDBManager extends BaseDBManager<User> {

	@Override
	public void purgeTable(String table) {
		// TODO Auto-generated method stub

	}

	public ArrayList<User> getAll() {
		UserDBManager user = new UserDBManager();
		return user.getAll(User.class);
	}

	@Override
	public void update(User item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User item) {
		// TODO Auto-generated method stub

	}

	@Override
	public <O> void mapRelation(User item, O relation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateWithChildren(User item) {
		// TODO Auto-generated method stub

	}

	@Override
	public <O> void updateChildren(User item, O sampleChild) {
		// TODO Auto-generated method stub

	}
}
