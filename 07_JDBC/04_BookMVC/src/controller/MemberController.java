package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	private MemberDAO dao = MemberDAO.getInstance();	
	
	//4. 회원가입
	public String register(Member member) {
       try {
		dao.register(member);
	    return	member.getName() + "님이 회원가입 하셨습니다!";
	   } catch (SQLException e) {
		   return "기존 회원아이디가 있어서 다른 아이디로 가입해주세요.";
	   }
    }//종료
			
	
	//5. 로그인
	public Member login(String id, String pwd) {
		try {			
		  return dao.login(id, pwd);
		} catch (SQLException e) {
			return null;
		}
		
	}//종료 
	
	//6. 회원탈퇴
	public boolean delete(String id) {
	      try {
			dao.delete(id);
			return true;
		  } catch (SQLException e) {
			return false;
		  }
		// 회원탈퇴 시 대여중인 책을 모두 기록 삭제
	}//종료
	
}//최종종료
