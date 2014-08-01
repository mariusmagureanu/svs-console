package com.svs.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="item")
@Inheritance(strategy=InheritanceType.JOINED)
public final class Item extends BaseEntity {

	private String name;
	private String description;

	public Item(String entityKey) {
		super(entityKey);
	}

	public Item() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void fromJSON(final JSONObject jsonSource) throws JSONException {
		this.setBasicJsonData(jsonSource);
		this.description = jsonSource.getString("description");
		this.name = jsonSource.getString("name");
	}

}
