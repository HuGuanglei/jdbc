package com.guanglei.entity;


public class CheckoutMaster {
	//pojo
	
	
	private int id;
	private String cashierName;
	private int totalAmount;
	private String transactionDateTime;
	private int totalAmountConsumer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCashierName() {
		return cashierName;
	}
	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public int getTotalAmountConsumer() {
		return totalAmountConsumer;
	}
	public void setTotalAmountConsumer(int totalAmountConsumer) {
		this.totalAmountConsumer = totalAmountConsumer;
	}
	
    
}
