package com.guanglei.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guanglei.bean.PosBean;
import com.guanglei.servies.PosService;
@Path("list")
public class PosRest {
	
	static final Logger logger = LoggerFactory.getLogger(PosRest.class); 
	@GET
    @Produces(MediaType.APPLICATION_XML)
	public List<PosBean> getAmountByDate(){
		List<PosBean> list = new ArrayList();
		PosService ps= new PosService();
		try {
			list=ps.getAmountByDate();
			logger.info("OK");
		}catch(Exception e){
			logger.error("RestAPI error",e);
		}
		return list;
	}
	

}
