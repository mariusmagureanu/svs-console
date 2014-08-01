package com.svs.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.json.JSONException;
import org.json.JSONObject;

@MappedSuperclass
public abstract class BaseEntity implements IBaseEntity {

	/**
	 * Represents an automatic entity id, handled by the database.
	 */
	@Id
	@GeneratedValue
	protected int id;

	/**
	 * Represents an Id which is already assigned to the entity. When importing
	 * data, some entities may already have their id's which can be of any type.
	 * For those ids use this field.
	 */
	protected String entityKey;

	public int getId() {
		return this.id;
	}

	public String getEntityKey() {
		return this.entityKey;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setEntityKey(final String entityKey) {
		this.entityKey = entityKey;
	}

	protected BaseEntity(final String entityKey) {
		this.entityKey = entityKey;
	}

	public abstract void fromJSON(final JSONObject jsonSource) throws JSONException;

	protected BaseEntity() {
	}
	
	protected void setBasicJsonData(final JSONObject jsonSource) throws JSONException
	{
		if (jsonSource.has("entityKey")) {
			this.entityKey = jsonSource.getString("entityKey");
		}
		if (jsonSource.has("id")) {
			this.id = jsonSource.getInt("id");
		}
	}

}