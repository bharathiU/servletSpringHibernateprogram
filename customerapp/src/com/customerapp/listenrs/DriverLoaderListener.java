package com.customerapp.listenrs;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class DriverLoaderListener implements ServletContextListener {
	  public void contextInitialized(ServletContextEvent event)  { 
    	  System.out.println("servlet context is initialized");
    	  String driverName=event.getServletContext().getInitParameter("driver");
    	  try{
  			Class.forName(driverName);
  			System.out.println("driver is loaded..");
  		}catch(ClassNotFoundException ex){
  			ex.printStackTrace();
  		}
    }
    public void contextDestroyed(ServletContextEvent arg0)  { 
       System.out.println("servlet context is destroyed");
    }

	
  
	
}
