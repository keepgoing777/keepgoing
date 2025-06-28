package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.controller.BookController;
import com.kh.practice2.controller.MemberController;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;


public class Application {
	 Scanner sc = new Scanner(System.in);
	 MemberController mc = new MemberController();
	 BookController bc = new BookController();
	 
   // 대여 가능한 책 목록
	 ArrayList<Book> books = new ArrayList<>();
	    {
	        books.add(new Book("디스 이즈 이탈리아", false, 0));
	        books.add(new Book("리얼 런던", true, 0));
	        books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
	        books.add(new Book("사퀴트리 샌드위치", false, 0));
	        books.add(new Book("원피스 111", true, 15));
	        books.add(new Book("귀멸의 칼날 23", false, 19));
	        books.add(new Book("진격의 거인 Before the fall 16", false, 19));
	    }
	 
	 
 public static void main(String[] args) {	
     Application a = new Application();
 	try {
		a.mainMenu();
	} catch(Exception e) {
		e.printStackTrace();
		System.out.println("잘못 입력하셨습니다! 다시 입력해주세요ㅠㅠ");
		a.mainMenu();
	}
  }
	/*
	 *  로그인 및 중복확인, 나이제한 
	 *  ===메뉴===
	 *  1.마이페이지 - 본인정보 확인 
	 *  2.도서 대여하기 (책 리스트 나오게)
	 *    1. 한 사람당 대여할 수 있는 책의 권수는 총 3권 "더 이상 대여할 수 없습니다."
	 *    2. 해당 사람이 대여한 책은 대여 불가능 "이미 대여한 책입니다."
	 *    3. 나이 제한에 걸리는 책들 대여 불가능 "나이 제한으로 대여 불가능합니다."
	 *    4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능 (true)
	 *    5. (선택사항) 각 책들마다 가능한 대여가 3권까지만
	 *    - HashMap 사용 (각각 값들에 접근하는 getOrDefault(키, 초기값) 
	 *    대여가능한 경우 : "성공적으로 대여되었습니다."
	 *  3.로그아웃
	 *  4.프로그램 종료
	 */ 
	
    
   //Menu 
   public void mainMenu() {
	         
	    	System.out.println("이름을 입력해 주세요.");
			 String name = sc.nextLine();
			System.out.println("나이를 입력해 주세요.");
			 int age = Integer.parseInt(sc.nextLine());
			 boolean result = mc.registerAndLogin(name, age);
			 if(!result) {
				 System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");
				 mainMenu();
			 }
			 boolean check = true;
			 while(check) {
			System.out.println("====메뉴====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 로그아웃");
			System.out.println("4. 프로그램 종료");
			System.out.println("번호를 입력해주세요.");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				System.out.println(mc.getMember());
				// (마이페이지 getMember)
				break;
			case 2: rentBook();
				// 도서 대여하기 rentBook
				break;
			case 3: 
				mc.logout();
				mainMenu();
				// 사용자가 많아질때 구현 (로그아웃 logout)
				break;
			case 4: 
				check = false;
				break;
			}
          }        
        }		 
		
   public void rentBook() {
	   //향상된 for문 : 값만 가지고 올 때 간단하게
	   //인덱스까지 필요하다면 일반 for문!!(북 리스트 먼저 보여주기)
	   for(int i = 0 ; i < books.size(); i++){
		   System.out.println(i + "번째" + books.get(i));	
		   }
	       int select = Integer.parseInt(sc.nextLine());
	       
	      Object result = bc.rentBook(books.get(select), mc.getMember());
	      if(result instanceof Member){
	    	  System.out.println("성공적으로 대여되었습니다.");
	    	  mc.setMember((Member)result);
	      }else {
	    	  System.out.println(result);
	      }
	    //내가 대여할 책 book 객체 하나 
	    //System.out.println(books.get(select));
	    //Member 객체에 bookList 여기에 추가 
	    //System.out.println(member.getBookList().add(books.get(select)));
        }
   
 } //app 종료



