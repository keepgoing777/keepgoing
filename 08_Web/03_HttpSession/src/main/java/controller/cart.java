package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;

@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ProductServlet에서 여기로 왔을 때도 member 정보를 가지고 오게끔! 
		
		HttpSession session = request.getSession();
		Member user = (Member) session.getAttribute("user");
		
		System.out.println("cart: " + user);
		
		//세션 정보 죽이기
		session.invalidate();
	}

}
