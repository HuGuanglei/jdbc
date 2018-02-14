package com.guanglei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="master_checkout")
public class CheckoutMaster2 {
	//pojo
	
	@Id
	@GeneratedValue
	@Column(name ="transaction_id")
	private int id;
	@Column(name ="cashier_name")
	private String cashierName;
	@Column(name ="total_amount")
	private int totalAmount;
	@Column(name ="transaction_date_time")
	private String transactionDateTime;
	@Column(name ="total_amount_consumer")
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
