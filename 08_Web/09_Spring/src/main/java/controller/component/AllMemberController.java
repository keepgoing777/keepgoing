package controller.component;

import java.util.List;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class AllMemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 MemberDAO dao = new MemberDAO();
	     List<Member> list = dao.resultAll();
			
		 request.setAttribute("list", list);
		 //request.getRequestDispatcher("/views/allMember.jsp").forward(request, response);
		 
		 return new ModelAndView("/views/allMember.jsp");
   }
 
}
