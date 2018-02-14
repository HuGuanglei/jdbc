package com.guanglei.servies;

import java.util.List;

import com.guanglei.hibernateDAO.MasterDao2;
import com.guanglei.bean.PosBean2;

public class PosService {
	MasterDao2 d = new MasterDao2();

	public List<PosBean2> getAmountByDate() {
		return d.findToday();
	}

}
