package com.svs.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public final class OrderLine extends BaseEntity {

	private String orderId;
	private String customerId;
	private String itemId;
	private String comments;
	private int quantity;
	
	public OrderLine(String entityKey) {
		super(entityKey);
	}
	
	public OrderLine() {}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void fromJSON(JSONObject jsonSource) {
		
	}

}
