package com.svs.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public final class User extends BaseEntity {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	public User(String entityKey) {
		super(entityKey);
	}

	public User() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void fromJSON(JSONObject jsonSource) throws JSONException {
		this.setBasicJsonData(jsonSource);
		this.firstName = jsonSource.getString("firstName");
		this.lastName = jsonSource.getString("lastName");
		this.userName = jsonSource.getString("userName");
		this.password = jsonSource.getString("password");
	}
}
