package com.svs.dao.tests;


import com.svs.dao.factory.DaoFactory;
import com.svs.entities.Customer;

public final class CustomerDaoTests extends BaseDaoTests<Customer>{

	@Override
	public void setUp() {
		this.dao = DaoFactory.getInstance().getDaoFactory().getCustomerDao();
	    
		this.testEntity = new Customer("11AB");
		this.testEntity.setName("Some funky customer name");
		this.testEntity.setAddress("Some funky customer address.");	
	}
}