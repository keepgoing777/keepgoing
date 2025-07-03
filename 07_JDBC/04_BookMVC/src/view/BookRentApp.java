package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;
import vo.Rent;

public class BookRentApp {
	
	private Scanner sc = new Scanner(System.in);
	private Member member = new Member();
	private Rent rent = new Rent();
	private Book book = new Book();
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();
	

	public static void main(String[] args) {
        BookRentApp app = new BookRentApp();
        app.menu();
 }//종료	
		
    public void menu() {
    while(true) {
    // 로그인 X
    System.out.println("1. 전체 책 조회");
    System.out.println("2. 회원가입");    
    System.out.println("3. 로그인");     
    
    //관리자 로그인 했을 때 (id:admin pwd:1234)
    System.out.println("1. 책 등록");    
    System.out.println("2. 책 삭제");    
    System.out.println("3. 로그아웃");
    
    //일반회원이 들어왔을 때
    System.out.println("1. 회원탈퇴");    
    System.out.println("2. 로그아웃");   
    System.out.println("3. 책 대여");    
    System.out.println("4. 내가 대여한 책 조회");    
    System.out.println("5. 대여취소");    
    System.out.println("선택 > ");
    int select = Integer.parseInt(sc.nextLine());
    switch (select) {
    case 1:    	
    	bc.printBookAll();
    	break;
    case 2:
    	mc.register();
    	break;
    case 3:
    	mc.login();
    	break;
    case 4:
    	bc.registerBook();
    	break;
    case 5:
    	bc.deleteBook();
    	break;
    case 6:
    	
    	break;
    case 7:
    	rc.rentBook();
    	break;
    case 8:
    	rc.printRentBook();
    	break;	 
    case 9:
    	rc.deleteRent();
        break;
    }
   } 
    
 }//종료
   
    // 1.회원가입
    public void register() {
    Member member = new Member();
    System.out.println("아이디 > ");
    member.setId(sc.nextLine());
    System.out.println("이름 > ");
    member.setName(sc.nextLine());
    System.out.println("비밀번호 > ");
    member.setPwd(sc.nextLine());
    System.out.println("나이 > ");
    member.setAge(Integer.parseInt(sc.nextLine()));
    }//종료
    
    // 2.로그인
     public void login(String id, String pwd) {
    	
    }//종료 
     
     //3.회원탈퇴
     public void delete(String id) {
 		
 	}//종료
     
     //4.책 전체 조회 
     public ArrayList<Book> PrintBookAll(){
   	  return null;
     }//종료
     
     //5.책 등록
     public void registerBook(String title, String author, int accessAge) {
   	  
     }//종료
     
     //6. 책 삭제 
     public void sellBook(int bookNo) {
   	  
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
