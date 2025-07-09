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

		//1. (있으면) 폼값 가져온다.(name) - string 타입 파라미터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//확인용
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(age);
	
		boolean check = true;
		
		//2. DAO호출 - DB 접근 필요 시 	
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
				
	    //3. 바인딩 : 결과 페이지에 서버에서 받은 값(ex. name) 보내야 할 때
		//request.setAttribute("name", name); // result.jsp에서 받아야함
		//위를 주석 걸고 result.jsp에 수정(getAttribute -> request.getParameter
		request.setAttribute("check", check);
		
		//4. 네비게이션 : 결과 페이지 지정 
		//check이 true인 경우 회원가입 성공 페이지로 이동 (result.jsp)
		//false인 경우 실패 페이지로 이동 (fail.jsp)
		
	 //  if(check) {
           request.getRequestDispatcher("result.jsp").forward(request, response);
		  //response.sendRedirect("result.jsp");
	      //4번 중 sendRedirect 는 강제로 페이지 이동시킴 name을 데리고 못감 (사용 X) 
		  //만약 결과 페이지로 서버에서 받은 값을 보여주려면
		  //->RequestDispatcher forward 방식으로 보내야함 
          //결과 페이지를 하나로!(여기에 fail.jsp 내용이 if 조건문으로 모두 들어가있음
	  // } else {
	  //  response.sendRedirect("fail.jsp");
	  // }
	  
	}//종료

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
