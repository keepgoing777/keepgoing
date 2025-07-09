package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		//1. 쿠키 생성
		Cookie c1 = new Cookie("id", "test");
		Cookie c2 = new Cookie("name", "테스트");
		
		//2. 쿠키 유효시간 지정 가능 
		c1.setMaxAge(5); //5초
	    c1.setMaxAge(60*60*24); //하루
		
		//3. 쿠키 브라우저 전송
		response.addCookie(c1);
		response.addCookie(c2);
	}

}
