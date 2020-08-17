package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

/**
 * Servlet implementation class RegisterImplServlet
 */
@WebServlet({ "/RegisterImplServlet", "/registerimpl" })
public class RegisterImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterImplServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		System.out.println(id+" "+pwd+" "+name);
		User user = new User(id, pwd, name);
		
		request.setAttribute("registeruser", user);
		RequestDispatcher rd = request.getRequestDispatcher("registerok.jsp");
		rd.forward(request, response);
	}

}
