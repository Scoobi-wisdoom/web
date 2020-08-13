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

@WebServlet({ "/GeoServlet", "/geo" })
public class GeoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		ArrayList<Geo> list = new ArrayList<>();
		JSONArray ja = new JSONArray();
		if(cmd.equals("0")) {
			list.add(new Geo("s1", 37.539530, 126.979045, "http://www.naver.com"));
			list.add(new Geo("s2", 37.549530, 126.989045, "http://www.daum.net"));
			list.add(new Geo("s3", 37.559530, 126.969045, "http://www.naver.com"));
			list.add(new Geo("s4", 37.569530, 126.929045, "http://www.naver.com"));
			list.add(new Geo("s5", 37.548530, 126.919045, "http://www.naver.com"));
			for(Geo geo: list) {
				JSONObject jo = new JSONObject();
				jo.put("name", geo.getName());
				jo.put("lat", geo.getLat());
				jo.put("lng", geo.getLng());
				jo.put("url", geo.getUrl());
				ja.add(jo);
			}
		}else if(cmd.equals("1")) {
			
		}
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
		
	}

}








