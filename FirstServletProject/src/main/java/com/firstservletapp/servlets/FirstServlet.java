package com.firstservletapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstServlet implements Servlet {
	
	ServletConfig config = null;
	
	
	// Life cicle of Servlet
	
	
	// 1- The init() function will be called.
	@Override
	public void init(ServletConfig config) throws ServletException {
		// The arg0 argument reads any configuration we wrote in web.xml file and placed inside the config Object "instance Variable".
		this.config = config;
		
	}
	
	
	//2- Then The service() Function is called.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter printWriter = res.getWriter();
		printWriter.print("<h1>Hello Rayan!</h1>");
		printWriter.print("<h2>" + new Date() + "</h2>");

		
	}
	//3-THen destroy() function called.
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//4- And then we have tow helpers.
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}
	//5-
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
