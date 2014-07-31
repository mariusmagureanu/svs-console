package com.svs.dao.mysql;

import org.hibernate.SessionFactory;

import com.svs.dao.interfaces.IOrderDao;
import com.svs.entities.Orders;

public final class OrderDao extends BaseDao<Orders> implements IOrderDao {

	protected OrderDao(SessionFactory sessionFactory, Class<Orders> entityType) {
		super(sessionFactory, entityType);
	}

}
