package com.svs.facade.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.svs.dao.factory.DaoFactory;
import com.svs.dao.interfaces.IBaseDao;
import com.svs.dao.interfaces.IOrderLineDao;
import com.svs.entities.OrderLine;
import com.svs.facade.interfaces.IOrderLineFacade;

public final class OrderLineFacade extends BaseFacade<OrderLine> implements
		IOrderLineFacade {

	private final IOrderLineDao dao = DaoFactory.getInstance().getDaoFactory()
			.getOrderLineDao();

	@Override
	public OrderLine fromJSON(String jsonData) throws JSONException {
		final JSONObject jsonOrderLine = new JSONObject(jsonData);
		final OrderLine orderLine = new OrderLine();
		orderLine.fromJSON(jsonOrderLine);
		return orderLine;
	}

	@Override
	protected IBaseDao<OrderLine> getBaseDao() {
		return this.dao;
	}

}
