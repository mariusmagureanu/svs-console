package com.svs.dao.tests;

import java.util.Date;

import com.svs.dao.factory.DaoFactory;
import com.svs.entities.Orders;

public final class OrdersDaoTests extends BaseDaoTests<Orders>{

	@Override
	public void setUp() {
		this.dao = DaoFactory.getInstance().getDaoFactory().getOrderDao();
		
		this.testEntity = new Orders();
		this.testEntity.setCustomerId("11-B");
		this.testEntity.setComments("No comments available for this order yet.");
		this.testEntity.setEntityKey("#12345#");
		this.testEntity.setOrderDate(new Date());
		this.testEntity.setStatus(true);
		
	}

}
