package com.guanglei.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.guanglei.entity.CheckoutMaster;
import com.guanglei.jdbc.JDBCUtils;

import org.assertj.core.api.EnumerableAssert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class MasterDaoTest {
	Connection con = null;
	CheckoutMaster cm = new CheckoutMaster();
	String date = "2013-01-28 13:24:56";
	MasterDao masterDAO = null;

	@Before
	public void setConnection() {

		masterDAO=new MasterDao();
		con = JDBCUtils.getConnection();
		cm.setCashierName("Roy");
		cm.setId(1);
		cm.setTotalAmount(20);
		cm.setTotalAmountConsumer(8);
		cm.setTransactionDateTime(date);
	}

	@Test
	public void testDAOAdd() {

	}

	@Test
	public void addTransactions() {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {

			String sql = "insert into master_checkout(transaction_id, cashier_name,total_amount,transaction_date_time"
					+ ",total_amount_consumer) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cm.getId());
			ps.setString(2, cm.getCashierName());
			ps.setInt(3, cm.getTotalAmount());
			ps.setString(4, cm.getTransactionDateTime());
			ps.setInt(5, cm.getTotalAmountConsumer());
			ps.executeUpdate();

			String sql1 = "SELECT * FROM master_checkout where transaction_id=" + cm.getId();
			ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery(sql1);
			rs.next();
			assertThat(1).isEqualTo(rs.getInt(1));
			assertThat("Roy").isEqualTo(rs.getString(2));
			assertThat(20).isEqualTo(rs.getInt(3));
			assertThat(rs.getString(4)).contains("2013-01-28 13:24:56");
			assertThat(8).isEqualTo(rs.getInt(5));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(null, ps, con);
		}
	}
}
