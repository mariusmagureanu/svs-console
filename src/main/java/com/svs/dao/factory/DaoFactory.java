package com.svs.dao.factory;

import com.svs.dao.mysql.MySqlFactory;

public final class DaoFactory {

	private static final Object lockObject = new Object();
	private static DaoFactory currentInstance = null;

	private IDaoFactory iFactory;

	public static DaoFactory getInstance() {
		synchronized (lockObject) {
			if (currentInstance == null) {
				currentInstance = new DaoFactory();
			}
		
			return currentInstance;
		}
	}

	private DaoFactory() {
		this.iFactory = new MySqlFactory();
	}

	public IDaoFactory getDaoFactory() {
		return this.iFactory;
	}
}
