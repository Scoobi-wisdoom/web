package com.sds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if(id.equals("id01")) {
			if(pwd.equals("pwd01")) {
				System.out.println("로그인 성공");
				response.sendRedirect("menu.html");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				response.sendRedirect("loginFail.html");
			}
		}
		
	}

}
