package com.svs.dao.mysql;

import org.hibernate.SessionFactory;

import com.svs.dao.interfaces.ICustomerDao;
import com.svs.entities.Customer;

public final class CustomerDao extends BaseDao<Customer> implements ICustomerDao {

	protected CustomerDao(SessionFactory sessionFactory, Class<Customer> entityType) {
		super(sessionFactory, entityType);		
	}
}
