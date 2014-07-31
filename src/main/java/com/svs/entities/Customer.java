package com.svs.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public final class Customer extends BaseEntity {

	public Customer(String entityKey) {
		super(entityKey);
	}
	
	public Customer() {}

	private String name;
	private String address;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void fromJSON(JSONObject jsonSource) {
	}
}