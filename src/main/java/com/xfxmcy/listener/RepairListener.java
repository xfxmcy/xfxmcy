package com.xfxmcy.listener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xfxmcy.service.RepairService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author CY
 * @Date 20-07
 * @description listener repair  data  
 * @version 0.0.1-SNAPSHOT
 */

public class RepairListener implements ServletContextListener{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RepairListener.class);
	
	private RepairService repairServiceImpl;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		
		logger.info("repair database ........");
		/*从spring context中获取bean, 所以spring listener 要配置在前面*/
		repairServiceImpl = (RepairService) (WebApplicationContextUtils.getWebApplicationContext(sc.getServletContext()).getBean("repairServiceImpl"));
		repairServiceImpl.repair();
		
	}

}
