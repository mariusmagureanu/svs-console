package com.svs.dao.tests;

import com.svs.dao.factory.DaoFactory;
import com.svs.entities.User;

public final class UserDaoTests extends BaseDaoTests<User> {

	@Override
	public void setUp() {
		this.dao = DaoFactory.getInstance().getDaoFactory().getUserDao();
		
		this.testEntity = new User();
		this.testEntity.setFirstName("John");
		this.testEntity.setLastName("Rambo");
		this.testEntity.setUserName("john_rambo");
		this.testEntity.setPassword("pass");
		this.testEntity.setEntityKey("11AB");		
	}
}
