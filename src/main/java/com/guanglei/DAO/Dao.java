package com.guanglei.DAO;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

import com.guanglei.DAO.Transactions;
import com.guanglei.jdbc.JDBCUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dao {
	
	static Logger logger = LoggerFactory.getLogger( Dao.class );
	
	public void addTransactions(Transactions tran) {
		Connection con = null ;  
        PreparedStatement ps = null ; 
        try  
        {  
            con = JDBCUtils.getConnection();  
            String sql = "insert into master_checkout(cashier_name,total_amount,transaction_date_time"
            		+ ",total_amount_consumer) values(?,?,?,?)";  
            ps = con.prepareStatement(sql);  
              
            ps.setString(1, tran.getCashierName());  
            ps.setFloat(2, tran.getTotalAmount());  
            ps.setString(3, tran.getTransactionDateTime());  
            ps.setInt(4, tran.getTotalAmountConsumer());   
            ps.executeUpdate() ;    
        }  
        catch(SQLException e)  
        {  
            logger.error("mysql inserting error",e);  
        }  
        finally  
        {  
            JDBCUtils.free(null, ps, con);  
        }	
	}
	
	public void delete(int id) {
		Connection con = null ;  
        PreparedStatement ps = null ;
        try {
        	con = JDBCUtils.getConnection();
        	String sql = "delete from master_checkout where id=?";
    		ps = con.prepareStatement(sql);  
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch(SQLException e){
        	logger.error("mysql deleting error",e);
        }
        finally  
        {  
            JDBCUtils.free(null, ps, con);  
        }	
	}
	
	public void update(int id)  
    {  
        Connection con = null ;  
        PreparedStatement ps = null ;   
        try  
        {  
            con = JDBCUtils.getConnection();  
            String sql = "update master_checkout set total_amount = total_amount + 1  "
            		+ "where transaction_id =?";  
            ps = con.prepareStatement(sql);  
            ps.setInt(1, id);  
            ps.executeUpdate() ;    
        }  
        catch(SQLException e)  
        {  
        	logger.error("mysql updating error",e);  
        }  
        finally  
        {  
            JDBCUtils.free(null, ps, con);  
        }   
    }
	
	public Transactions findTransaction(int id)  
    {  
        Connection con = null ;  
        PreparedStatement ps = null ;  
        Transactions tran = null;  
        ResultSet rs = null;  
        try  
        {  
            con = JDBCUtils.getConnection();  
            String sql = "select * from master_checkout where transaction_id =?";  
            ps = con.prepareStatement(sql);  
            ps.setInt(1, id);  
            rs = ps.executeQuery() ;  
              
            while(rs.next())  
            {  
            	tran = new Transactions();
            	tran.setId(rs.getInt(1));
                tran.setCashierName(rs.getString(2));  
                tran.setTotalAmount(rs.getFloat(3));  
                tran.setTransactionDateTime(rs.getString(4));  
                tran.setTotalAmountConsumer(rs.getInt(5));  
            }  
              
        }  
        catch(SQLException e)  
        {  
        	logger.error("mysql selecting data error",e);  
        }  
        finally  
        {  
            JDBCUtils.free(rs, ps, con);  
        }  
          
        return tran;  
    }  	
}
