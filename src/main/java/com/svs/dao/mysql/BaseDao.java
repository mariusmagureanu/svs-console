package com.svs.dao.mysql;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.svs.dao.interfaces.IBaseDao;
import com.svs.entities.IBaseEntity;

public abstract class BaseDao<T extends IBaseEntity> implements IBaseDao<T> {

	protected SessionFactory sessionFactory;
	private Class<T> entityType;

	/**
	 * 
	 * @param sessionFactory
	 * @param clazz
	 */
	protected BaseDao(final SessionFactory sessionFactory, final Class<T> clazz) {
		this.sessionFactory = sessionFactory;
		this.entityType = clazz;
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getByKey(String entityKey) {
		T t = null;
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		final Criteria criteria = session.createCriteria(this.entityType);
		t = (T) criteria.add(Restrictions.eq("entityKey", entityKey))
				.uniqueResult();

		session.getTransaction().commit();
		session.close();

		return t;
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getById(int entityId) {
		T t = null;
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		final Criteria criteria = session.createCriteria(this.entityType);
		t = (T) criteria.add(Restrictions.eq("id", entityId)).uniqueResult();

		session.getTransaction().commit();
		session.close();

		return t;
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> getAll() {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		final ArrayList<T> list = (ArrayList<T>) session.createCriteria(
				this.entityType).list();

		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * 
	 */
	@Override
	public boolean update(T entity) {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean deleteEntity(T entity) {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * 
	 */
	@Override
	public boolean saveEntity(T entity) {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	@Override
	public void clearAll() {
		final Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		final String deleteQuery = String.format("delete from %s",this.entityType.getSimpleName());
		session.createQuery(deleteQuery).executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
}
