package com.httpservletresponse.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class BinaryStreamExample
 */
public class BinaryStreamExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BinaryStreamExample() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// There is more than image/png,text/html,text/css ...etc You can search for the
		// Mime type and pass it.
		
		// Setting Response Mime Type
		response.setContentType("image/png"); // Mime Type, The default Mime Type is text/html

		// Response Binary Stream.
		ServletOutputStream outputStream = response.getOutputStream();

		// 1- Open Stream
		InputStream inputStream = getServletContext().getResourceAsStream("images/pic.png");
		
		// 2- Define byte Array
		byte[] imageBytes = new byte[inputStream.available()];
		
		// 3- Read the Image
		inputStream.read(imageBytes);
		
		// 4- Write Image Bytes on Servlet Output Stream
		outputStream.write(imageBytes);
		
		// 5- Flush the response
		outputStream.flush();
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
