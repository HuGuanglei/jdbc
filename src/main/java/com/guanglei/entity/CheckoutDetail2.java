package com.guanglei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkout_detail")
public class CheckoutDetail2 {
	@Id
	@GeneratedValue
	@Column(name ="transaction_id")
	private int masterId;
	@Column(name ="product_id")
	private String productId;
	@Column(name ="product_amount")
	private double productAmount;
	@Column(name ="id")
	private int id;
	
	public int getMasterId() {
		return masterId;
	}
	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CheckoutDetail [masterId=" + masterId + ", productId=" + productId + ", productAmount=" + productAmount
				+ ", id=" + id + "]";
	}
	
	

}
