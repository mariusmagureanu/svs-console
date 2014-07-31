package com.svs.facade.impl;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.svs.dao.interfaces.IBaseDao;
import com.svs.entities.IBaseEntity;
import com.svs.facade.interfaces.IBaseFacade;

public abstract class BaseFacade<T extends IBaseEntity> implements
		IBaseFacade<T> {

	protected abstract IBaseDao<T> getBaseDao();

	@Override
	public T find() {
		return null;
	}

	@Override
	public T save(final T entity) {
		this.getBaseDao().saveEntity(entity);
		return entity;
	}

	@Override
	public ArrayList<T> getAll() {
		final ArrayList<T> entities = this.getBaseDao().getAll();
		return entities;
	}

	@Override
	public JSONArray toJSONArray(final ArrayList<T> entities)
			throws JSONException {
		final JSONArray jsonEntities = new JSONArray();

		for (final T t : entities) {
			final JSONObject jsonEntity = this.toJSON(t);
			jsonEntities.put(jsonEntity);
		}
		return jsonEntities;
	}

	@Override
	public JSONObject toJSON(final T t) throws JSONException {
		final JSONObject jsonEntity = new JSONObject(t);
		jsonEntity.put("id", t.getId());
		jsonEntity.put("entityKey", t.getEntityKey());
		return jsonEntity;
	}
}
