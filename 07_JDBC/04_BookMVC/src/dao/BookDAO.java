package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Book;

public class BookDAO {
	
	private static BookDAO instance = new BookDAO(); 

	public BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//종료
	
	public static BookDAO getInstance() {
		return instance;
	}//종료
	
	public Connection connect () throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	

  //1. 전체 책 조회
  public ArrayList<Book> printBookAll() throws SQLException{
	  Connection connect = connect();
	  String query = "SELECT * FROM BOOK";
	  PreparedStatement ps = connect.prepareStatement(query);
	  ResultSet rs = ps.executeQuery();
	  ArrayList<Book> list = new ArrayList<>();
	  while(rs.next()) {
		 /* Book book = new Book();
		  book.setBookNo(rs.getInt("book_no")); 
		  book.setTitle(rs.getString("title"));
		  book.setAuthor(rs.getString("author"));
		  book.setAccessAge(rs.getInt("accessAge"));	  */
		  //Book book = new Book(rs.getInt("bookNo"), rs.getString("title"), rs.getString("author"), rs.getInt("accessAge"));
		  list.add(new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("accessAge")));		
	  }
	  return list;
	  	  
  }//종료
  
  //타이틀, 저자, 접근 제한 완전히 일치한 경우 확인
  public boolean checkBook(String title, String author, int accessAge) throws SQLException {
	  Connection connect = connect();
	  String query = "SELECT * FROM book WHERE title = ? AND author = ? AND access_age = ? ";
	  PreparedStatement ps = connect.prepareStatement(query);
	  ps.setString(1, title);
	  ps.setString(2, author);
	  ps.setInt(3, accessAge);
	  
	  ResultSet rs = ps.executeQuery();
	  return rs.next();
  }
  //2. 책 등록
  public void registerBook(String title, String author, int accessAge) throws SQLException {
	  Connection connect = connect();
	  String query = "INSERT INTO BOOK(title, author, accessAge) VALUES(?,?,?)";
	  PreparedStatement ps = connect.prepareStatement(query);
	  ps.setString(1, title);
	  ps.setString(2, author);
	  ps.setInt(3, accessAge);
	  ps.executeUpdate();	
	  
  }//종료
  
  //제목으로 책 조회
  public int searchBook(String title) throws SQLException {
	  Connection connect = connect();
	  String query = "SELECT book_no * FROM book WHERE title = ? ";
	  PreparedStatement ps = connect.prepareStatement(query);
	  ps.setString(1, title);
	  ResultSet rs = ps.executeQuery();
	  if(rs.next()) {
		  return rs.getInt("book_no");
	  }
      return -1;
  }
  
  
  
  //3. 책 삭제 
  public int sellBook(int bookNo) throws SQLException {
	  Connection connect = connect();
	  String query = "DELETE FROM BOOK WHERE book_no = ? "; //book_no (not bookNo
	  PreparedStatement ps = connect.prepareStatement(query);
	  ps.setInt(1, bookNo); //bookNo (book 클래스 내 내용 삭제)
	  return ps.executeUpdate();
	}//종료
}//최종종료
