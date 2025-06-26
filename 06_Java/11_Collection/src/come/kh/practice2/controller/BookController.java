package come.kh.practice2.controller;

import java.util.HashMap;
import java.util.Map;

import come.kh.practice2.model.Book;
import come.kh.practice2.model.Member;

public class BookController {

//(선택사항) 책 제목 기준으로 현재 대여 인원 수 파악
	private Map<String, Integer> bookCount = new HashMap<>();
	
	//책 대여
	public String rentBook(Book book, Member member) {
		return null;
	}
	
}
