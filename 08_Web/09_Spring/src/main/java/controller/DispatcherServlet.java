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
import java.util.Arrays;
import java.util.List;

import dao.MemberDAO;

/*
 * Factory Method Pattern
 * - 추상화된 클래스의 객체(구상객체, 실체 클래스)를 생성하고 반환받는 방법
 * 
 * 1. 구상객체를 실질적으로 생성하는 곳으로 싱글톤 패턴으로 작성된 Factory(공장)에서 진행된다.
 *    이때 넘어오는 command 값에 따라서 서로 다른 구상객체가 만들어진다.
 *    정작 사용자(클라이언트)에게는 추상화된 클래스로 날아간다.
 *    
 * --> 결국 클라이언트는 Factory로 하여금 구상객체를 만들도록 요청하는 것이고
 *     Factory는 요청에 해당하는 제품을 만들고 인터페이스로 전달한다.
 *    
 * 2. 인터페이스의 메서드를 호출하면
 *    실질적으로 생성된 구상객체가 핵심적인 일(비즈니스 로직 호출) 진행
 *    최종적으로 뷰(화면)의 경로를 리턴받는다.
 * */


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //hidden 값으로 들어온 요청 받지 않고 들어온 요청의 주소를 직접 인식
		String requestURI = request.getRequestURI();		
		String [] requestURIList = requestURI.split("/");
		String command = requestURIList[requestURIList.length - 1];
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			ModelAndView mv = controller.handle(request, response);
		
		if(mv.isRedirect()) response.sendRedirect(mv.getPath());
		else request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	
	}//service종료
	 
}//최종종료
