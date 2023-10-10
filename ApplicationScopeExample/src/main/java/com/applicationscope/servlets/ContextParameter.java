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
import java.util.Enumeration;

public class ContextParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContextParameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 3-
		config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		
		ServletContext servletContext = request.getServletContext();
		
		printWriter.print("<h2> Context parameters  </h2> <br/>");
		printWriter.print("<h3> DB IP Param:" + servletContext.getInitParameter("db-ip") + " </h3>");
		printWriter.print("<h3> DB Port Param:" + servletContext.getInitParameter("db-port") + " </h3>");
		
		// If you do not know the parameters name.
		Enumeration<String> enumeration =  servletContext.getInitParameterNames();
		// Loop
		while (enumeration.hasMoreElements()) {
		    String name = enumeration.nextElement();
		    printWriter.print(name + " ");
		}
		
		
		
		// You can access ServletContext methods through these objects

		// 1- request obj.
//		request.getServletContext();
		// 2- Access the method directly , becouse it defined in the HTTPServlet class.
//		getServletContext();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
