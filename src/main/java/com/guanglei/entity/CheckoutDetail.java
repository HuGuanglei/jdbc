package com.guanglei.entity;

public class CheckoutDetail {
	private int masterId;
	private String productId;
	private double productAmount;
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
