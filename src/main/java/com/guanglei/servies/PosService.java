package com.guanglei.servies;

import java.util.List;

import com.guanglei.DAO.MasterDao;
import com.guanglei.bean.PosBean;

public class PosService {
	MasterDao d = new MasterDao();

	public List<PosBean> getAmountByDate() {
		return d.findToday();
	}

}
