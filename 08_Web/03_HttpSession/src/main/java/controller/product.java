package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;


@WebServlet("/product")
public class product extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //member 데이터!
   		System.out.println("product servlet!");
   		Member member = (Member) request.getAttribute("member");
   		
   		//1. 세션 받아온다.
   		HttpSession session = request.getSession();
   		
   		//2. 세션에 바인딩된 값이 있다면 그 값을 찾아온다.
   		Member user = (Member) session.getAttribute("user");
   		
   		System.out.println(member); //request : null 값
   		System.out.println(user);// Session : Member [id, pwd] 값
   		
   		response.sendRedirect("cart");
	}

}
