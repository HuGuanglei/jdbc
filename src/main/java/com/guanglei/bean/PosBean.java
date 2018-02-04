package com.guanglei.bean;
import javax.xml.bind.annotation.*;
@XmlRootElement
public class PosBean {
	
	
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
	public void setProductAmount(double productAmmount) {
		this.productAmount = productAmount;
	}
	@Override
	public String toString() {
		return "PosBean [productId=" + productId + ", productAmount=" + productAmount + "]";
	}
	
	

}
