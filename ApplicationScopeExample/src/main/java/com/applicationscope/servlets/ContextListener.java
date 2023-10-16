package com.applicationscope.servlets;

import java.sql.Connection;

import com.applicationscope.dbconnection.DBConeection;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Hi, Application Stopped");
		
		boolean isClosed = DBConeection.closeConnection();
		System.out.println("Connection is Closed? ==> "+ isClosed);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Hi, Application Strated");
		ServletContext servletContext = sce.getServletContext();
		
		
		Connection connection = DBConeection.openConnection();
		servletContext.setAttribute("db-connection", connection);
		System.out.println("Connection is established !");
		
	}

}
