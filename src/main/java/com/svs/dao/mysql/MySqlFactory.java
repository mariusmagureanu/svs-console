package com.svs.dao.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.svs.dao.factory.IDaoFactory;
import com.svs.dao.interfaces.ICustomerDao;
import com.svs.dao.interfaces.IItemDao;
import com.svs.dao.interfaces.IOrderDao;
import com.svs.dao.interfaces.IOrderLineDao;
import com.svs.dao.interfaces.IUserDao;
import com.svs.entities.Customer;
import com.svs.entities.Item;
import com.svs.entities.OrderLine;
import com.svs.entities.Orders;
import com.svs.entities.User;

@SuppressWarnings("deprecation")
public final class MySqlFactory implements IDaoFactory {

	private final SessionFactory sessionFactory;
	private final ServiceRegistry serviceRegistry;

	public MySqlFactory() {
		final Configuration hibernateConfiguration = new Configuration();
		hibernateConfiguration.configure();
		this.serviceRegistry = new ServiceRegistryBuilder().applySettings(
				hibernateConfiguration.getProperties()).build();

		this.sessionFactory = hibernateConfiguration.buildSessionFactory(this.serviceRegistry);
	}

	@Override
	public ICustomerDao getCustomerDao() {
		return new CustomerDao(this.sessionFactory, Customer.class);
	}

	@Override
	public IItemDao getItemDao() {
		return new ItemDao(this.sessionFactory, Item.class);
	}

	@Override
	public IOrderDao getOrderDao() {
		return new OrderDao(this.sessionFactory, Orders.class);
	}

	@Override
	public IOrderLineDao getOrderLineDao() {
		return new OrderLineDao(this.sessionFactory, OrderLine.class);
	}

	@Override
	public IUserDao getUserDao() {
		return new UserDao(this.sessionFactory, User.class);
	}
}
