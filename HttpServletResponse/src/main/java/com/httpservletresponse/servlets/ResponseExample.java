package com.httpservletresponse.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ResponseExample
 */
public class ResponseExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Response Structure :
     * 1- Status Code ==> 200, 404,500 ...etc
     * 2- Response Headers ==> Location , Cookies , Refresh 
     * 3- Repsonse Body ==> HTML + Dynamic Content(Java), Text Stream(HTML) Binary Stream(image,pdf ..etc
     */
    public ResponseExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
