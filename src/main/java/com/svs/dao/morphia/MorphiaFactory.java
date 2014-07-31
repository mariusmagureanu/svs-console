package com.svs.dao.morphia;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.svs.dao.factory.IDaoFactory;
import com.svs.dao.interfaces.ICustomerDao;
import com.svs.dao.interfaces.IItemDao;
import com.svs.dao.interfaces.IOrderDao;
import com.svs.dao.interfaces.IOrderLineDao;
import com.svs.dao.interfaces.IUserDao;

public final class MorphiaFactory implements IDaoFactory {

	private static final String DB_NAME = "svs";
	private Mongo mongo;
	private Morphia morphia;
	@SuppressWarnings("unused")
	private Datastore datastore;

	@SuppressWarnings("deprecation")
	public MorphiaFactory() {
		try {
			this.mongo = new Mongo();
			this.morphia = new Morphia();
			this.morphia.mapPackage("com.svs.entities", true);
			this.datastore = this.morphia.createDatastore(this.mongo, DB_NAME);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ICustomerDao getCustomerDao() {
		return new CustomerDao(this.mongo, this.morphia, DB_NAME);
	}

	@Override
	public IItemDao getItemDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOrderDao getOrderDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOrderLineDao getOrderLineDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IUserDao getUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
