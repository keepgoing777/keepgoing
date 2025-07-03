package controller;

import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {
	
	BookDAO b = new BookDAO();
	
  //1. 전체 책 조회
  public ArrayList<Book> PrintBookAll(){
	return null;
	
  }//종료
  
  //2. 책 등록
  public boolean registerBook(String title, String author, int accessAge) {
	  //기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되게
	  return false;
  }//종료
  
  //3. 책 삭제 
  public boolean sellBook(int bookNo) {
	  //빌려있는 책은 삭제 못하게! 
	  return false;
  }//종료
}//최종종료
