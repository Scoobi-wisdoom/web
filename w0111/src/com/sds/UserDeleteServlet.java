package com.sds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import frame.Controller;
import vo.User;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet({ "/UserDeleteServlet", "/userdelete" })
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Controller<String, User> controller;

    public UserDeleteServlet() {
        super();
        controller = new UserController();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User dbuser = null;
		try {
			controller.remove(id);
			response.sendRedirect("seletall");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
