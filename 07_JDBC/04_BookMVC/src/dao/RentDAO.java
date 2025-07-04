package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;
import vo.Rent;

public class RentDAO {
	
	private static RentDAO instance = new RentDAO();
	
	public RentDAO() {
	try {
		Class.forName(ServerInfo.DRIVER);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
  }//종료
	
	public static RentDAO getInstance() {
		return instance;
	}//종료
	
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
  }//종료

	
  	//7. 책 대여
	public void rentBook(String id, int bookNo) throws SQLException {
		 Connection connect = connect();
		  String query = "INSERT INTO RENT(id, book_no) VALUES(?, ?)";
		  PreparedStatement ps = connect.prepareStatement(query);
		  ps.setString(1, id);
		  ps.setInt(2, bookNo);
		  ps.executeUpdate();	
		
	}//종료
	

	
	//8. 내가 대여한 책
	public ArrayList<Rent> printRentBook(String id) throws SQLException{
		  Connection connect = connect();
		  String query = "SELECT * FROM rent JOIN book USING(book_no) WHERE id = ?";
		  PreparedStatement ps = connect.prepareStatement(query);
		  ps.setString(1, id);
		  
		  ResultSet rs = ps.executeQuery();
		  ArrayList<Rent> list = new ArrayList<>();
		  while(rs.next()) {
		      Rent rent = new Rent();
		      rent.setRentNo(rs.getInt("rent_no"));
		      rent.setId(rs.getString("id"));
		      rent.setBookNo(rs.getInt("book_no"));
		      rent.setRentDate(rs.getDate("rent_date").toLocalDate()); // toLocalDate(); 필수
			  rent.setBook(new Book(rs.getInt("book_no"), rs.getString("title"), 
					                rs.getString("author"), rs.getInt("access_age")));
		      
		      list.add(rent);		
		  }
		  return list;
		
	}//종료
	
	
	// 책 제목으로 rent_no값 조회
		public int selectRent(String title, String id) throws SQLException {
			Connection connect = connect();
			
			String query = "SELECT rent_no FROM rent JOIN book USING(book_no) WHERE title = ? AND id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("rent_no");
			}
			return -1;
		}
	
	//9. 대여 취소
	public void deleteRent(int rentNo) throws SQLException {
		Connection connect = connect();
		  String query = "DELETE FROM RENT WHERE rent_no = ? "; 
		  PreparedStatement ps = connect.prepareStatement(query);
		  ps.setInt(1, rentNo);
		  ps.executeUpdate();
		
	}//종료
	
	
	public int selectRent(int bookNo) throws SQLException {
		Connection connect = connect();
		
		String query = "SELECT count(*) as count FROM rent WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt("count");
		}
		return -1;
	}
	
}//최종종료
