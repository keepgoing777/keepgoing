package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberDAO dao = new MemberDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 인코딩 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//1. (있으면) 폼값 가져온다.(name)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//확인용
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(age);
	
		//2. DAO호출 - DB 접근 필요 시 		
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// age int라서 1. 폼값 age를 선언 변경
		//PrintWriter out = response.getWriter();
		//out.println("<html><body>");
		//out.println("<h4>" + "아이디 : " + id + "</h4>");
		//out.println("<h4>" + "비밀번호 : " + pwd + "</h4>");
		//out.println("<h4>" + "이름 : " + name + "</h4>");
		//out.println("<h4>" + "나이 : " + age + "</h4>");
		//out.println("</body></html>");
		//out.close();
		
		//3. 결과 페이지(result.jsp)
		response.sendRedirect("result.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
