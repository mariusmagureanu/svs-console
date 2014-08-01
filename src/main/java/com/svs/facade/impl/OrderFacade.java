package com.svs.facade.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.svs.dao.factory.DaoFactory;
import com.svs.dao.interfaces.IBaseDao;
import com.svs.dao.interfaces.IOrderDao;
import com.svs.entities.Orders;
import com.svs.facade.interfaces.IOrderFacade;

public final class OrderFacade extends BaseFacade<Orders> implements
		IOrderFacade {

	private final IOrderDao dao = DaoFactory.getInstance().getDaoFactory()
			.getOrderDao();

	@Override
	public Orders fromJSON(String jsonData) throws JSONException {
		final JSONObject jsonOrder = new JSONObject(jsonData);
		final Orders order = new Orders();
		order.fromJSON(jsonOrder);
		return order;
	}

	@Override
	protected IBaseDao<Orders> getBaseDao() {
		return this.dao;
	}

}
