package com.svs.facade.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.svs.dao.factory.DaoFactory;
import com.svs.dao.interfaces.IBaseDao;
import com.svs.dao.interfaces.IUserDao;
import com.svs.entities.User;
import com.svs.facade.interfaces.IUserFacade;

public final class UserFacade extends BaseFacade<User> implements IUserFacade {

	private final IUserDao userDao = DaoFactory.getInstance().getDaoFactory()
			.getUserDao();

	@Override
	public boolean isValidUser(String username, String password) {
		return false;
	}

	@Override
	public User fromJSON(String jsonData) throws JSONException {
		final JSONObject j = new JSONObject(jsonData);
		final User user = new User();
		user.fromJSON(j);
		return user;
	}

	@Override
	protected IBaseDao<User> getBaseDao() {
		return this.userDao;
	}
}
