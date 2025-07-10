package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDAO {

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
   
   //4. 로그인
   public Member login(String id, String pwd) throws SQLException {
	   Connection connect = connect();
	   String query = "SELECT * FROM member WHERE id = ? AND pwd = ?";
	   PreparedStatement ps = connect.prepareStatement(query);
	   ps.setString(1, id);
	   ps.setString(2, pwd);
	   ResultSet rs = ps.executeQuery();
	   Member member = null;
	   if(rs.next()) {
		   member = new Member(id,pwd, rs.getString("name"), rs.getInt("age"));
	   } return member;
	   
   }
   
   //5. 회원검색(회원 아이디로 정보 조회)
   public Member search(String id) throws SQLException {
	   Connection connect = connect();	   
	   String query = "SELECT * FROM member WHERE id = ?";
	   PreparedStatement ps = connect.prepareStatement(query);
	   ps.setString(1, id);
	   ResultSet rs = ps.executeQuery();
	   Member member = null;
	   if(rs.next()) {
		   member = new Member(id, rs.getString("name"),
				   rs.getString("pwd"), rs.getInt("age"));				   
	   }
	   return member;
   }
   
   //4. 전체 회원보기
   public List<Member> resultAll() throws SQLException {
	   Connection connect = connect();	   
	   String query = "SELECT * FROM member";
	   PreparedStatement ps = connect.prepareStatement(query);
	   ResultSet rs = ps.executeQuery();
	   List<Member> list = new ArrayList<>();
	   while(rs.next()) {
		  list.add(new Member(rs.getString("id"), rs.getString("pwd"),
				   rs.getString("name"), rs.getInt("age")));				   
	   }
	   return list;
   }
      
}//최종종료