package controller;

import controller.component.AllMemberController;
import controller.component.LoginController;
import controller.component.LogoutController;
import controller.component.RegisterController;
import controller.component.SearchController;

/*
 * Controller들을 만들어내는 공장
 * DispatcherServlet에서 보내주는 command 값에 따라서 생성하는 Controller가 달라진다.
 * 여러개의 Controller들을 만들어 내지만 공장에 해당하는 HandlerMapping은 
 * 단 하나면 충분하기 때문에 싱글톤 패턴 작성
 * 
 **/

public class HandlerMapping {
	
     //싱글톤 패턴 만들기
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {
		
	}
	
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("register.do")) {
			controller = new RegisterController();
		} else if (command.equals("login.do"))	{
			controller = new LoginController();
		} else if (command.equals("search.do")) {
			controller = new SearchController();
		} else if (command.equals("allmember.do")) {
			controller = new AllMemberController();
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
		}	
		return controller;
		
	}//Controller 종료	
}//최종종료
