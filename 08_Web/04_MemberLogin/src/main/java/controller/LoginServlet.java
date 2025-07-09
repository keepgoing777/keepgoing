package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String id = request.getParameter("id");
		    String pwd = request.getParameter("pwd");
		    
		    MemberDAO dao = new MemberDAO();
		    Member member;
			try {
				member = dao.login(id, pwd);
		
		    
		    //HttpSession (서버가 꺼지기전까지 정보 보관)
		    //1. 세션을 하나 받는다.
		    HttpSession session = request.getSession();
		    //2. 세션에 바인딩
		    session.setAttribute("member", member);
		  
		    response.sendRedirect("/");	
			
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("/");
			}	    
	}

}
