package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class GetProductServlet
 */
@WebServlet({ "/GetProductServlet", "/getproduct" })
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 카테고리 1번 담배
		ArrayList<Product> list1 = new ArrayList<>();
		list1.add(new Product(10, "에쎄", "c1", 4500, 50, 0));
		// 카테고리 2번 생필품
		ArrayList<Product> list2 = new ArrayList<>();
		list2.add(new Product(20, "휴지", "c2", 3000, 30, 0));

		// 카테고리 3번 음료
		ArrayList<Product> list3 = new ArrayList<>();
		list3.add(new Product(30, "사이다", "c3", 2700, 40, 0));
		// 카테고리 4번 과자
		ArrayList<Product> list4 = new ArrayList<>();
		list4.add(new Product(40, "썬칩", "c4", 1500, 20, 0));
		// 카테고리 5번 라면
		ArrayList<Product> list5 = new ArrayList<>();
		list5.add(new Product(50, "열라면", "c5", 800, 15, 0));
		// 카테고리 6번 즉석식품
		ArrayList<Product> list6 = new ArrayList<>();
		list6.add(new Product(60, "삼각김밥", "c6", 1000, 25, 0));

		JSONArray ja1 = new JSONArray();
		for (Product p : list1) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("category_id", p.getCategory_id());
			obj.put("price", p.getPrice());
			obj.put("num", p.getNum());
			obj.put("cuml", p.getCuml());
			ja1.add(obj);
		}

		JSONArray ja2 = new JSONArray();
		for (Product p : list2) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("category_id", p.getCategory_id());
			obj.put("price", p.getPrice());
			obj.put("num", p.getNum());
			obj.put("cuml", p.getCuml());
			ja2.add(obj);
		}

		JSONArray ja3 = new JSONArray();
		for (Product p : list3) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("category_id", p.getCategory_id());
			obj.put("price", p.getPrice());
			obj.put("num", p.getNum());
			obj.put("cuml", p.getCuml());
			ja3.add(obj);
		}

		JSONArray ja4 = new JSONArray();
		for (Product p : list4) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("category_id", p.getCategory_id());
			obj.put("price", p.getPrice());
			obj.put("num", p.getNum());
			obj.put("cuml", p.getCuml());
			ja4.add(obj);
		}

		JSONArray ja5 = new JSONArray();
		for (Product p : list5) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("category_id", p.getCategory_id());
			obj.put("price", p.getPrice());
			obj.put("num", p.getNum());
			obj.put("cuml", p.getCuml());
			ja5.add(obj);
		}

		JSONArray ja6 = new JSONArray();
		for (Product p : list6) {
			JSONObject obj = new JSONObject();
			obj.put("id", p.getId());
			obj.put("name", p.getName());
			obj.put("category_id", p.getCategory_id());
			obj.put("price", p.getPrice());
			obj.put("num", p.getNum());
			obj.put("cuml", p.getCuml());
			ja6.add(obj);
		}

		// senData에서 넘어오는 num 에따라 데이터 전송
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String data = request.getParameter("categoryN");
		if (data.equals("ja1")) {
			out.print(ja1.toJSONString());
		} else if (data.equals("ja2")) {
			out.print(ja2.toJSONString());
		} else if (data.equals("ja3")) {
			out.print(ja3.toJSONString());
		} else if (data.equals("ja4")) {
			out.print(ja4.toJSONString());
		} else if (data.equals("ja5")) {
			out.print(ja5.toJSONString());
		} else if (data.equals("ja6")) {
			out.print(ja6.toJSONString());
		}
	}

}
