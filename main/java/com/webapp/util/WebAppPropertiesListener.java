package com.webapp.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppPropertiesListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String rootPath = arg0.getServletContext().getRealPath("/");
        System.setProperty("webroot", rootPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
