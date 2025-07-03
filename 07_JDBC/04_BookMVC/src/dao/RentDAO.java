package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Rent;

public class RentDAO {
	
	public RentDAO() {
	try {
		Class.forName(ServerInfo.DRIVER);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
  }//종료
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
  }//종료

	
  	//7. 책 대여
	public void rentBook(String id, int bookNo) {
		
	}//종료
	
	//8. 내가 대여한 책
	public ArrayList<Rent> printRentBook(String id){
		return null;
	}//종료
	
	//9. 대여 취소
	public void deleteRent(int rentNo) {
		
	}//종료
	
}//최종종료
