package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	private MemberDAO dao = MemberDAO.getInstance();	
	
	//4. 회원가입
	public void register(Member member) {
       try {
		dao.register(member);
	   } catch (SQLException e) {
		e.printStackTrace();
	   }
    }//종료
			
	
	//5. 로그인
	public Member login(String id, String pwd) {
		return null;
	}//종료 
	
	//6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴 시 대여중인 책을 모두 기록 삭제
	}//종료
	
}//최종종료
