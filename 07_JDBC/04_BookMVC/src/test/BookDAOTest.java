package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.BookDAO;
import vo.Book;

public class BookDAOTest {

	private BookDAO dao;
	
	@BeforeEach
	void setUp() {
		dao = BookDAO.getInstance();
	}
	
	
	@AfterEach
	void setDown() throws SQLException {
		dao.connect().prepareStatement("DELETE FROM BOOK").executeUpdate();
	}
	
	
	
	@Test
	void registerBook() throws SQLException {
		dao.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
		
	    ArrayList<Book> list = dao.PrintBookAll();
	    assertEquals(list.get(0).getAuthor(),"하태완");
	}
	
    @Test
	void sellBook() throws SQLException {
		dao.registerBook("오늘의 낙원에서 만나자", "하태완", 15);
		
		ArrayList<Book> list = dao.PrintBookAll();
		
		dao.sellBook(list.get(0).getBookNo());
		list = dao.PrintBookAll(); // sellBook이후에 한번더 확인 후 assert로 넘어가야함
		
		// error  assertEquals(list.size(), 1); 
		 assertEquals(list.size(), 0); 
		 assertTrue(list.isEmpty());
	
	}
	

	
	
}//전체종료
