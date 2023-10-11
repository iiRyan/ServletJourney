package com.httprequest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HttpRequest
 */
public class HttpRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Request Object : Object that represents the data that is sent from the web
	 * browser and received by the web container wich convert it to a java object.
	 * This java object carries many most importantly parameters, then the
	 * attributes, the header request data, such as locale, content type and content
	 * length.
	 */
	public HttpRequest() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// Request Object content : HTTP Request object wich sent from web browser :
		// Header + Body(Parameters)

		// Request Headers
		// 1- Locale : Language ==> Response depend on the locale
		out.print("<h1> Request Locale : " + request.getLocale() + "</h1>");
		// 2- Content Length :
		out.print("<h1> Request Length : " + request.getContentLength() + "</h1>");
		// 3- Server Name :
		out.print("<h1> Request Server Name : " + request.getServerName() + "</h1>");
		// 4- Content Type (Mine Type) --> The data Type whether it is binary or TEXT
		out.print("<h1> Request Content Type : " + request.getContentType() + "</h1>");
		// 5- Context Path
		out.print("<h1> Request Context Path : " + request.getContextPath() + "</h1>");
		// 6- Parameter (Request Body)
		out.print("<h1> Request User Name Parameter : " + request.getParameter("userName") + "</h1>");
		out.print("<h1> Request Contry Parameter : " + request.getParameter("country") + "</h1>");
		
		// Quiz : HTML Request Headers
		request.getHeader("");
		request.getHeaderNames();
	}

}
