package com.svs.dao.mysql;

import org.hibernate.SessionFactory;

import com.svs.dao.interfaces.IOrderLineDao;
import com.svs.entities.OrderLine;

public final class OrderLineDao extends BaseDao<OrderLine> implements IOrderLineDao {

	protected OrderLineDao(SessionFactory sessionFactory,Class<OrderLine> entityType) {
		super(sessionFactory, entityType);
	}
}
