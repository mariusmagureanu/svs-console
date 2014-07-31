package com.svs.dao.mysql;

import org.hibernate.SessionFactory;

import com.svs.dao.interfaces.IItemDao;
import com.svs.entities.Item;

public final class ItemDao extends BaseDao<Item> implements IItemDao {

	protected ItemDao(SessionFactory sessionFactory, Class<Item> entityType) {
		super(sessionFactory, entityType);
	}

}
