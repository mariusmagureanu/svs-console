package com.svs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
public final class Orders extends BaseEntity {

	private String customerId;
	private Date orderDate;
	private String comments;
	private boolean status;

	public Orders(String entityKey) {
		super(entityKey);
	}

	public Orders() {
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public void fromJSON(JSONObject jsonSource) throws JSONException {
		this.setBasicJsonData(jsonSource);
		this.customerId = jsonSource.getString("customerId");
		this.orderDate = new Date(jsonSource.getLong("orderDate"));
        this.comments = jsonSource.getString("comments");
        this.status = jsonSource.getBoolean("status");
	}
}
