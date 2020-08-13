package com.sds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet({ "/WeatherServlet", "/weather" })
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlstr = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?serviceKey=AZCeEwBFCkBZ%2FI%2FGJx2IE6iMYIEAss%2Bhtd%2BXYrcldFGlaskvErHI74v567hq61c1AfwDuneRWZKFilAfw1ST%2Bw%3D%3D&pageNo=1&numOfRows=10&dataType=XML&dataCd=ASOS&dateCd=DAY&startDt=20100101&endDt=20100601&stnIds=108&";
		String xmlstr = getRequest(urlstr,"");
		response.setContentType("text/xml;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(xmlstr);
	}

	public static String getRequest(String url, String parameter) {

		try {
			String param = "{\"param\":\"" + parameter + "\"} ";
			// url�� �ν��Ͻ��� �����.
			URL uri = new URL(url);
			// HttpURLConnection �ν��Ͻ��� �����´�.
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			// Web Method�� Post Ÿ��
			connection.setRequestMethod("GET");
			// ��û�Ѵ�. 200�̸� �����̴�.
			int code = connection.getResponseCode();
			if (code == 200) {
				// ���� �� body ������ stream�� �޴´�.
				try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					String line;
					StringBuffer buffer = new StringBuffer();
					while ((line = input.readLine()) != null) {
						buffer.append(line);
					}
					return buffer.toString();

				}
			}
			return code + "";

		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}
