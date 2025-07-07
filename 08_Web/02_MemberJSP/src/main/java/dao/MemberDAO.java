package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import vo.Member;

public class MemberDAO {

 Member m = new Member();
	
	public MemberDAO() {

	//1. 드라이브 로딩 & 싱글톤 패턴 미포함
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
  }//종료
    
   //2. 디비연결
   public Connection connect() throws SQLException {
	   return DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "qwer1234");
   }
	
   //3. 회원가입 
   public void register(Member member) throws SQLException {
	   Connection connect = connect();
	   String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
	   PreparedStatement ps = connect.prepareStatement(query);
	   ps.setString(1, member.getId());
	   ps.setString(2, member.getName());
	   ps.setString(3, member.getPwd());
	   ps.setInt(4, member.getAge());
	   
	   ps.executeUpdate();
   }
}//최종종료
