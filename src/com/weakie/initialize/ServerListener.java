package com.weakie.initialize;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.weakie.util.log.LogUtil;
/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public final class ServerListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerListener() {
    	LogUtil.info("new ServerListener");
    }

	public void contextDestroyed(ServletContextEvent arg0) {
		String name = arg0.getServletContext().getServletContextName();
		LogUtil.info("destroy "+name);
		
		Initialize instance = Initialize.getInstance();
		try {
			instance.shutdown();
		} catch (IOException e) {
			LogUtil.error(e);
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		String name = arg0.getServletContext().getServletContextName();
		LogUtil.info("initial "+name);
		
		Initialize instance = Initialize.getInstance();
		try {
			instance.startup();
		} catch (IOException e) {
			LogUtil.error(e);
		}
	}
	
}
