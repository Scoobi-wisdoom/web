package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDataServelt
 */
@WebServlet({ "/GetDataServelt", "/getdata" })
public class GetDataServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Call Service Method ...");
		// Data 생성해서 Response
		// Ajax
		Random r = new Random();
		int num = r.nextInt(100)+1;
		response.setContentType("text/html;charset=euc-kr"); // httpresonse에 char을 안 깨지게 하기 위해서 하는 작업. 해당 html의 charset과 동일해야 함.
		PrintWriter out = response.getWriter();
		out.print(num+"");
	}

}
