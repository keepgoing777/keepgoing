package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
			
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		 //1. 폼값(파라미터) 받기
        String id = request.getParameter("id");
        
        
        try {
        	//2. DB 정보 필요 -> MemberDAO
       	     MemberDAO dao = new MemberDAO();
        	 Member member = dao.search(id);
        
            // 결과를 request에 저장
            request.setAttribute("member", member);
            //request.setAttribute("searchId", id);
            
            // search.jsp로 포워딩
            request.getRequestDispatcher("search.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

}
