package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;

/**
 * Servlet implementation class LoginImplServlet
 */
@WebServlet({ "/LoginImplServlet", "/loginimpl" })
public class LoginImplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginImplServlet() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB Matching
		
		//System.out.println(id+" "+pwd);
		if(id.equals("qq") && pwd.equals("11")) {
			HttpSession session = request.getSession();
			System.out.println(session.toString());
			User user = new User(id, pwd, "");
			session.setAttribute("loginuser", user);
			request.setAttribute("loginid", id);
			request.setAttribute("centerpage", "loginok");
			
		}else {
			request.setAttribute("centerpage", "loginfail");
		}
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}
	
}
