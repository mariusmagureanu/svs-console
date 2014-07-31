package com.svs.dao.morphia;

import java.util.ArrayList;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import com.svs.dao.interfaces.IBaseDao;
import com.svs.entities.IBaseEntity;

public abstract class BaseDao<T extends IBaseEntity, K> extends BasicDAO<T, K>
		implements IBaseDao<T> {

	protected BaseDao(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, java.lang.String.valueOf(dbName));
	}

	@Override
	public T getByKey(String entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getById(int entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEntity(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveEntity(T entity) {
		return false;
	}

	@Override
	public void clearAll() {

	}
}
