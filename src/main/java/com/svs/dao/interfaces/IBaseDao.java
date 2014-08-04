package com.svs.dao.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import com.svs.entities.IBaseEntity;

public interface IBaseDao <T extends IBaseEntity>{
	
	T getByKey(final String entityKey);
	
	T getById(final int entityId);
	
	T getByFields(final HashMap <String, String> fields);
	
	ArrayList<T> getAllByFields(final HashMap <String, String> fields);
	
	ArrayList<T> getAll();
	
	boolean update(final T entity);
	
	boolean deleteEntity(final T entity);
	
	boolean saveEntity(final T entity);
	
	void clearAll();
	
}
