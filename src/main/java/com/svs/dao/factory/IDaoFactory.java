package com.svs.dao.factory;

import com.svs.dao.interfaces.ICustomerDao;
import com.svs.dao.interfaces.IItemDao;
import com.svs.dao.interfaces.IOrderDao;
import com.svs.dao.interfaces.IOrderLineDao;
import com.svs.dao.interfaces.IUserDao;


public interface IDaoFactory {

	 ICustomerDao getCustomerDao();
	 IItemDao getItemDao();
	 IOrderDao getOrderDao();
	 IOrderLineDao getOrderLineDao();
	 IUserDao getUserDao();
}
