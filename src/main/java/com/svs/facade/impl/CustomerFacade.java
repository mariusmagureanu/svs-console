package com.svs.facade.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.svs.dao.factory.DaoFactory;
import com.svs.dao.interfaces.IBaseDao;
import com.svs.dao.interfaces.ICustomerDao;
import com.svs.entities.Customer;
import com.svs.facade.interfaces.ICustomerFacade;

public final class CustomerFacade extends BaseFacade<Customer> implements
		ICustomerFacade {

	private final ICustomerDao dao = DaoFactory.getInstance().getDaoFactory()
			.getCustomerDao();

	@Override
	public Customer fromJSON(String jsonData) throws JSONException {
		final JSONObject jsonCustomer = new JSONObject(jsonData);
		final Customer customer = new Customer();
		customer.fromJSON(jsonCustomer);
		return customer;
	}

	@Override
	protected IBaseDao<Customer> getBaseDao() {
		return this.dao;
	}
}
