package com.sds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("t1");
		String pwd = request.getParameter("p1");
		String radio = request.getParameter("r1");
		String[] checkbox = request.getParameterValues("c1");
		String id = request.getParameter("id");
		System.out.println(id);
		System.out.println(text+" "+pwd+" "+radio);
		System.out.println(Arrays.toString(checkbox));
//		if(id.equals("id00")) {
//			response.sendRedirect("a4.html");
//		} else if(id.equals("id01")) {
//			response.sendRedirect("a3.html");
//		} else {
//			response.sendRedirect("a2.html");
//		}
		
		
		
	}

}
