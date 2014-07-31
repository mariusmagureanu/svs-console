package com.svs.facade.interfaces;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.svs.entities.IBaseEntity;

public interface IBaseFacade<T extends IBaseEntity> {

	T save(T entity);

	T fromJSON(final String jsonData) throws JSONException;

	T find();
	
	ArrayList<T> getAll();
	
	JSONObject toJSON(final T entity) throws JSONException;
	
	JSONArray toJSONArray(final ArrayList<T> entities) throws JSONException;
	
	
}
