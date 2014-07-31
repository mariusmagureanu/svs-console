package com.svs.dao.mysql;

import org.hibernate.SessionFactory;

import com.svs.dao.interfaces.IUserDao;
import com.svs.entities.User;

public final class UserDao extends BaseDao<User> implements IUserDao {

	protected UserDao(SessionFactory sessionFactory, Class<User> entityType) {
		super(sessionFactory, entityType);
	}

	@Override
	public void doStuff() {
		// TODO Auto-generated method stub
		
	}

}
