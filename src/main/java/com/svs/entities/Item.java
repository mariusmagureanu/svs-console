package com.svs.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table
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
	public void fromJSON(JSONObject jsonSource) {
		
	}

}
