package controller.component;

import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

/*
 * 컴포너트
 *  - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스 
 * */
public class RegisterController implements Controller {
	
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		MemberDAO dao = new MemberDAO();
		dao.register(new Member(id, pwd, name, age));
		
	    return new ModelAndView("index.jsp", true);
	}//ModelAndView 종료	
}
