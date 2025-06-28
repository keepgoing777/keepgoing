package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {

    //(선택사항) 책 제목 기준으로 현재 대여 인원 수 파악
	private Map<String, Integer> bookCount = new HashMap<>();
	
	MemberController mc = new MemberController();
	
	//책 대여
	 public Object rentBook(Book book, Member member) {
		ArrayList<Book> list = member.getBookList();
	       
	       
		 //1. 한 사람 당 대여할 수 있는 책은 총 3권
		 if(list.size() > 2) {
  			 return "더 이상 대여할 수 없습니다.(1인당 3권까지)"; 
		 } 
		  //2. 해당 사람이 대여한 책은 대여 불가능(기존 list에 해당책이 있는 경우 대여 못하게 return)
	     if(list.contains(book)) {
	    	 return "이미 대여한 책입니다."; 
	     }
	      //3. 나이 제한 (쿠폰이 없는경우)
	     if(member.getCoupon() == 0 && member.getAge() < book.getAccessAge()) {
	    	 return "나이 제한으로 대여 불가능합니다.";
	     }
	     //5. 각 책들마다 가능한 대여가 3권까지만(사람이 여러명인 경우)
	     // book 객체에 count 추가 하고 나머지 기존은 this로 다시 생성 
	     if(book.getCount()>2) {
	    	 return "더 이상 이 책은 대여할 수 없습니다.(1권당 3명까지)";
	     }	    
	     //대여 가능!
	     //book 객체에 count 추가한 방법
	     book.setCount(book.getCount()+1);	     
	 
	     //4. 나이 제한인데 쿠폰이 있는 경우 
    	 // 책에 쿠폰이 있으면 내 쿠폰에 하나 추가 (true = 쿠폰있음, false = 쿠폰없음) 
	     if(book.isCoupon()){
 	    	member.setCoupon(member.getCoupon()+1) ;     	 
	     }	    		 
	     if(member.getAge() < book.getAccessAge()) {
	    	 member.setCoupon(member.getCoupon()-1);
	    	 // 쿠폰 사용! (멤버가 가지고 있는 쿠폰에서 -1) 
	     }
	       list.add(book); //실질적인 대여 가능 경우 
	       member.setBookList(list);
           return member;
	   
	 } //rentBook 종료
	 
 } //bc. 종료


