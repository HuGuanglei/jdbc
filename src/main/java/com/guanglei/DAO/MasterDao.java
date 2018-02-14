package com.guanglei.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guanglei.bean.PosBean;
import com.guanglei.entity.CheckoutMaster;
import com.guanglei.jdbc.JDBCUtils;

public class MasterDao {

	static Logger logger = LoggerFactory.getLogger(MasterDao.class);

	public void addTransactions(CheckoutMaster tran) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "insert into master_checkout(transaction_id, cashier_name,total_amount,transaction_date_time"
					+ ",total_amount_consumer) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, tran.getId());
			ps.setString(2, tran.getCashierName());
			ps.setFloat(3, tran.getTotalAmount());
			ps.setString(4, tran.getTransactionDateTime());
			ps.setInt(5, tran.getTotalAmountConsumer());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("mysql inserting error", e);
		} finally {
			JDBCUtils.free(null, ps, con);
		}
	}

	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "delete from master_checkout where transaction_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("mysql deleting error", e);
		} finally {
			JDBCUtils.free(null, ps, con);
		}
	}

	public void update(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "update master_checkout set total_amount = total_amount + 1  " + "where transaction_id =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("mysql updating error", e);
		} finally {
			JDBCUtils.free(null, ps, con);
		}
	}

	public List<PosBean> findToday() {
		List<PosBean> list = new ArrayList();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		Connection con = null;
		Statement st = null;
		Statement st1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			con = JDBCUtils.getConnection1();
			st = con.createStatement();
			String sql = "select transaction_id from master_checkout where transaction_date_time like '" + date1 + "%'";
			logger.info(sql);
			rs = st.executeQuery(sql);
			logger.info("master select success");
			while (rs.next()) {
				String sql1 = "select product_id,product_amount from checkout_detail where transaction_id ="
						+ rs.getInt(1) + "";
				logger.info(sql1);
				st1 = con.createStatement();
				rs1 = st1.executeQuery(sql1);
				logger.info("detail select success");

				PosBean p = new PosBean();
				while (rs1.next()) {
					
					p.setProductId(rs1.getString("product_id"));
					p.setProductAmount(rs1.getDouble("product_amount"));
					logger.info(String.valueOf(rs1.getDouble("product_amount")));
					list.add(p);

				}
				JDBCUtils.free(rs1, st1, null);
			}
		} catch (Exception e) {
			logger.error("sql execution error", e);
		} finally {
			JDBCUtils.free(rs, st, con);

		}
		return list;
	}

	public CheckoutMaster findTransaction(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		CheckoutMaster tran = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "select * from master_checkout where transaction_id =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				tran = new CheckoutMaster();
				tran.setId(rs.getInt(1));
				tran.setCashierName(rs.getString(2));
				tran.setTotalAmount(rs.getInt(3));
				tran.setTransactionDateTime(rs.getString(4));
				tran.setTotalAmountConsumer(rs.getInt(5));
			}

		} catch (SQLException e) {
			logger.error("mysql selecting data error", e);
		} finally {
			JDBCUtils.free(rs, ps, con);
		}

		return tran;
	}
}
