package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

/**
 * Servlet implementation class SelectAllservlet
 */
@WebServlet({ "/SelectAllservlet", "/selectall" })
public class SelectAllservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllservlet() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("id01", "pwd01", "james1"));
		list.add(new User("id02", "pwd02", "james2"));
		list.add(new User("id03", "pwd03", "james3"));
		list.add(new User("id04", "pwd04", "james4"));
		list.add(new User("id05", "pwd05", "james5"));
	}

}
