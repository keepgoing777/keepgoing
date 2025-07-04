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

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	//로그인 했을 때 사용자 정보 담을 객체! null로 전제
	private Member member = null;

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
		app.menu1();
		app.menu2();
		app.menu3();

	}// 종료

	public void menu() {
		while (true) {
			if (member == null) {
				// 로그인 안되어있을 경우
				menu1();
			} else if (member.getId().equals("admin") && member.getPwd().equals("1234")) {
				menu2();// 관리자로 들어온 경우 
			} else { 
				menu3();
			}
		}
	}// 종료

	public void menu1() {
		System.out.println("1. 전체 책 조회");
		System.out.println("2. 회원가입");
		System.out.println("3. 로그인");
		System.out.println("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			printBookAll();
			break;
		case 2:
			register();
			break;
		case 3:
			login();
			break;
		}

   }//종료
	
    //전체 책 조회
	private void printBookAll() {
		ArrayList<Book> list = bc.printBookAll();
		if(list!= null && list.size() > 0 ) {
			for(Book b : list) {
			System.out.println(b);
	     	}
		}else {
			System.out.println("등록된 책이 없습니다.. 등록해주세요..");
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

	    System.out.println(mc.register(member));
	    
	}// 종료

	// 2.로그인
	// admin 1234
	public void login() {
		System.out.println("아이디 > ");
		String id = sc.nextLine();
		System.out.println("비밀번호 > ");
		String pwd = sc.nextLine();
		Member member = mc.login(id, pwd);
		if (member != null) {
			this.member = member;
			System.out.println(member.getName() + "님이 로그인 하셨습니다!");
		} else {
			System.out.println("로그인 실패.. 아이디와 비밀번호를 다시 입력해주세요");
		}

	}// 종료

	public void menu2() {
		System.out.println("1. 책 등록");
		System.out.println("2. 책 삭제");
		System.out.println("3. 로그아웃");
		System.out.println("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			registerBook();
			break;
		case 2:
			sellBook();
			break;
		case 3:
			this.member = null;
			break;
		}
	}// 종료
	
	// 1. 책 등록
		public void registerBook() {
			System.out.println("책 제목 > ");
			String title = sc.nextLine();
			System.out.println("책 저자 > ");
			String author = sc.nextLine();
			System.out.println("책 연령제한 > ");
			int accessAge = Integer.parseInt(sc.nextLine());
			if(bc.registerBook(title, author, accessAge)) {
				System.out.println(title + "책 등록이 완료되었습니다!");
			}else {
				System.out.println("책 등록하는 데 실패하셨습니다. 다시 등록해주세요!");
			}
			
    }//종료
		
    // 2. 책 삭제
		public void sellBook() {
			printBookAll();
			System.out.println("삭제할 책 제목 > ");
			String title = sc.nextLine();
			bc.sellBook(title);
			if(bc.sellBook(title)) {
				System.out.println(title + "이 삭제되었습니다.");
			}else {
				System.out.println("책 삭제하는데 실패했습니다 ㅠㅠ ");
			}
    }//종료
	

	public void menu3() {
		
		System.out.println("1. 회원탈퇴");    
	    System.out.println("2. 로그아웃");   
	    System.out.println("3. 책 대여");    
	    System.out.println("4. 내가 대여한 책 조회");    
	    System.out.println("5. 대여취소");    
	    System.out.println("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
	    switch (select) { 
	    case 1:
		    delete(); 
			break;
	    case 2:
			this.member = null;
			break;
	    case 3:
			rentBook();
			break;
		case 4:
		    printRentBook();
			break;
		case 5:
			deleteRent();
			break;
     	}
    }//종료
	// 3.회원탈퇴
	public void delete() {
         mc.delete(this.member.getId());
         this.member = null;
	}// 종료

	// 7. 책 대여
	public void rentBook() {
		printBookAll();
		System.out.println("대여할 책 제목 > ");
		String title = sc.nextLine();
	   if(rc.rentBook(this.member.getId(), title)) {
		   System.out.println(this.member.getName()+"님이 " + title + "을 대여하였습니다..");
	   }else {
		  System.out.println("대여하는데 실패하였습니다 ㅠㅠ"); 
	   }

	}// 종료

	// 8. 내가 대여한 책
	public void printRentBook() {
		ArrayList<Rent> list = rc.printRentBook(this.member.getId());
		if(list.size() > 0) {
			for(Rent r : list) {
				System.out.println(r.getBook());
			}
		} else {
			System.out.println("대여한 책이 없습니다. 대여해주세요!");
		}
	}// 종료

	// 9. 대여 취소
	public void deleteRent() {
		printRentBook();
		System.out.print("취소할 대여 책 제목 > ");
		String title = sc.nextLine();
		if(rc.deleteRent(title, this.member.getId())) {
			System.out.println("대여가 취소되었습니다.");
		} else {
			System.out.println("취소하는데 실패하였습니다.");
		}

	}// 종료

}// 최종종료
