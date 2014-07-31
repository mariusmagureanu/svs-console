package com.svs.dao.tests;

import com.svs.dao.factory.DaoFactory;
import com.svs.entities.Item;

public final class ItemDaoTests extends BaseDaoTests<Item>{

	@Override
	public void setUp() {
		this.dao = DaoFactory.getInstance().getDaoFactory().getItemDao();
		
		this.testEntity = new Item();
		this.testEntity.setName("Some funky item name");
		this.testEntity.setDescription("We know there's precisely one type argument in our class, so we can take the first element of the array that is returned, which provides the Class of our entity");
		this.testEntity.setEntityKey("I-22-B");
	}
}
