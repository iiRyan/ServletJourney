package com.applicationscope.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Servlet implementation class TestDbConnection
 */
public class TestDbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * It is better to define Servlet context at the class Level so that it can be
	 * invoked from any object inside the servlet class.
	 */
	
	ServletContext servletContext = null;
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		/*
		 * We defined it here cuz we don't have to define this reference with every
		 * received request, it's good to define it in the init so that it will be
		 * executed only once, And it will be available at the class level,and can be invoked using doGet
		 * doPost ,getSevletConfig,getServletInfo.
		 */		servletContext = getServletContext(); // Or you can access from config.getServletContext()
	}
   
    public TestDbConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  response.getWriter();
		Connection connection = (Connection) servletContext.getAttribute("employee-connection-db");
		
		out.print("<h1> Employee Object is Obtained From context: "
		+connection + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
