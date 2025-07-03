package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;
import vo.Member;

public class BookDAO {
	
	public BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//종료
	
	public Connection connect () throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	

  //1. 전체 책 조회
  public ArrayList<Book> PrintBookAll() throws SQLException{
	  Connection connect = connect();
	  String query = "";
	  PreparedStatement ps = connect.prepareStatement(query);
	  return null;
  }//종료
  
  //2. 책 등록
  public void registerBook(String title, String author, int accessAge) {
	  
  }//종료
  
  //3. 책 삭제 
  public void sellBook(int bookNo) {
	  
  }//종료
}//최종종료
