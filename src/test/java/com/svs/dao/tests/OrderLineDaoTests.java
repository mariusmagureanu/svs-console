package com.svs.dao.tests;

import com.svs.dao.factory.DaoFactory;
import com.svs.entities.OrderLine;

public final class OrderLineDaoTests extends BaseDaoTests<OrderLine>{

	@Override
	public void setUp() {
		this.dao = DaoFactory.getInstance().getDaoFactory().getOrderLineDao();
		
		this.testEntity = new OrderLine();
		this.testEntity.setComments("No comments available for this order line yet.");
		this.testEntity.setCustomerId("11-B");
		this.testEntity.setEntityKey("#22-33-44#");
		this.testEntity.setItemId("I-22-B");
		this.testEntity.setOrderId("#1234#");
		this.testEntity.setQuantity(20);
		
	}
	

}
