package com.guanglei.servies;
import com.guanglei.DAO.Transactions;
import com.guanglei.DAO.Dao;



public class servies {
	Dao d =new Dao();
	public void add(Transactions tran) {
		this.d.addTransactions(tran);
	}
	
	public void delete(int id) {
		this.d.delete(id);
	}
	
	public void update(int id) {
		this.d.update(id);
	}
	
	public Transactions findTransactions(int id) {
		return this.d.findTransaction(id);
	}	
}
