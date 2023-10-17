package com.sessiontracking.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println("User Name : "+ userName);
		System.out.println("Password : " + password);
		
		out.print("<h3> User Name : " +userName+ "</h3><br/>");
		out.print("<h3> Password : " +password+ "</h3><br/>");
		
		//Auth User ==> DB or LDAP
		Cookie userNameCookie = new Cookie("userName", userName);
		Cookie passwordCookie = new Cookie("password", password);
		
		
		// Add the cookies to the clinet's browser.
		response.addCookie(userNameCookie);
		response.addCookie(passwordCookie);
		
		out.print("<a href='/displayCookiesServlet'> Display Cookies </a>");

	}

}
