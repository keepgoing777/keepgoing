package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 파라미터는 html의 name값으로
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu");

		System.out.println(id);
		System.out.println(pwd);
		System.out.println(gender);
		System.out.println(Arrays.toString(menu));

		gender = gender.equals("M") ? "남자" : "여자";

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h4>" + "아이디 : " + id + "</h4>");
		out.println("<h4>" + "비밀번호 : " + pwd + "</h4>");
		out.println("<h4>" + "성별 : " + gender + "</h4>");
		// 1. 배열 out.println("<h4>" + "좋아하는 메뉴 : " + String.join(", ", menu) +"</h1>");

		// 2. for 반복문, if절 (null 제외)
		if (menu != null) {
			out.println("<h4>좋아하는 메뉴</h4>");
			out.println("<ul>");
			for (String m : menu) {
				out.println("<li>" + m + "</li>");
				out.println("</ul>");
			}
		}
		
		out.println("</body></html>");
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
