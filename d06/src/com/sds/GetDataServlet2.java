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
 * Servlet implementation class GetDataServlet2
 */
@WebServlet({ "/GetDataServlet2", "/getData2" })
public class GetDataServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("cmd");
		System.out.println(data);
//		Random r = new Random();
//		int num = r.nextInt(100)+1;
//		
//		response.setContentType("text/html;charset=euc-kr"); // httpresonse�� char�� �� ������ �ϱ� ���ؼ� �ϴ� �۾�. �ش� html�� charset�� �����ؾ� ��.
//		PrintWriter out = response.getWriter();
//		out.print(data+", "+num);
	}

}
