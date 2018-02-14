package com.guanglei.hibernateDAO;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guanglei.bean.PosBean2;
import com.guanglei.entity.CheckoutDetail2;
import com.guanglei.entity.CheckoutMaster2;

public class MasterDao2 {

	static Logger logger = LoggerFactory.getLogger(MasterDao2.class);

	public List<PosBean2> findToday() {
		PosBean2 p = new PosBean2();
		List<PosBean2> pos = new ArrayList();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		Session session = null;
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		try {
			session = factory.openSession();
			session.beginTransaction();
			List<CheckoutMaster2> cmList = session
					.createQuery("from CheckoutMaster2 cm where cm.transactionDateTime = '" + date1 + "'").list();
			for (CheckoutMaster2 cm : cmList) {
				List<CheckoutDetail2> cdList = session
						.createQuery("from CheckoutDetail2 cd where cd.masterId ='" + cm.getId() + "'").list();
				for(CheckoutDetail2 cd : cdList) {
					p.setProductId(cd.getProductId());
					p.setProductAmount(cd.getProductAmount());
					logger.info(Double.toString(cd.getProductAmount()));
					pos.add(p);
				}
			}
		} catch (Exception e) {
			logger.error("hibernateDao error", e);

		}
		return pos;
	}

}
