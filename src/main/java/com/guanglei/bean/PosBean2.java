package com.guanglei.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
@XmlRootElement

public class PosBean2 {
	
	private String productId;
	private double productAmount;
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
	@Override
	public String toString() {
		return "PosBean [productId=" + productId + ", productAmount=" + productAmount + "]";
	}
}
