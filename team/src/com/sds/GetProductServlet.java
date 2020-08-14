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
		// ī�װ� 1�� ���
		ArrayList<Product> list1 = new ArrayList<>();
		list1.add(new Product(10, "����", "c1", 4500, 50, 0));
		// ī�װ� 2�� ����ǰ
		ArrayList<Product> list2 = new ArrayList<>();
		list2.add(new Product(20, "����", "c2", 3000, 30, 0));

		// ī�װ� 3�� ����
		ArrayList<Product> list3 = new ArrayList<>();
		list3.add(new Product(30, "���̴�", "c3", 2700, 40, 0));
		// ī�װ� 4�� ����
		ArrayList<Product> list4 = new ArrayList<>();
		list4.add(new Product(40, "��Ĩ", "c4", 1500, 20, 0));
		// ī�װ� 5�� ���
		ArrayList<Product> list5 = new ArrayList<>();
		list5.add(new Product(50, "�����", "c5", 800, 15, 0));
		// ī�װ� 6�� �Ｎ��ǰ
		ArrayList<Product> list6 = new ArrayList<>();
		list6.add(new Product(60, "�ﰢ���", "c6", 1000, 25, 0));

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

		// senData���� �Ѿ���� num ������ ������ ����
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
