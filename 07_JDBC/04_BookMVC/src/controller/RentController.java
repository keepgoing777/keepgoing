package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import dao.RentDAO;
import vo.Rent;

public class RentController {

    RentDAO dao = RentDAO.getInstance();		
	BookDAO bookDAO = BookDAO.getInstance();
	
	//7. 책 대여
	public boolean rentBook(String id, String title) {
		try {
			dao.rentBook(id, bookDAO.searchBook(title));
			return true;
		} catch (SQLException e) {
			return false;
		}
		//한 사람당 대여할 수 있는 책은 총 5권
		//중복 책 대여 불가능
		//나이 제한 걸리는 책도 불가능
		//각 책들마다 가능한 대여가 2권까지만
	}//종료
	
	//8. 내가 대여한 책
	public ArrayList<Rent> printRentBook(String id){
		try {
			return dao.printRentBook(id);
		} catch (SQLException e) {
			return null;
		}		
	}//종료
	
	//9. 대여 취소
	public boolean deleteRent(String title, String id) {
		try {
			dao.deleteRent(dao.selectRent(title, id));
			return true;
		} catch (SQLException e) {
			return false;
		}
	
	}//종료
	
}//최종종료
