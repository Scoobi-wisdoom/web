package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		path = path.substring(1, path.lastIndexOf("."));
		System.out.println("Request: "+path);
		String next = "main.jsp";
		
		if(path.equals("main")) {
			next = "main.jsp";
		}else if(path.equals("login"))  {
			next = "main.jsp";
			request.setAttribute("centerpage", "login");
		}else if(path.equals("register")) {
			next = "main.jsp";
			request.setAttribute("centerpage", "register");
		}else {
			next = path;
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
