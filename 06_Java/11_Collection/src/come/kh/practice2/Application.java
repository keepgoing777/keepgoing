package come.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import come.kh.practice2.model.Book;
import come.kh.practice2.model.Member;


public class Application {
	 Scanner sc = new Scanner(System.in);
	 ArrayList<Member> members = new ArrayList<>();
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
     a.mainMenu();
     a.mypage();
     a.borrowbook();
     a.logout();
     
 }
	/*
	 * 이름 : 
	 * 나이 : 
	 * 회원가입과 로그인 같이 됨, 여러명 전제
	 * 기존에 회원 중 이름이 있으면 "이미 존재하는 이름입니다. 다시 입력해주실래요?"
	 * 
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
	 * 
	 */
        //로그인 및 중복확인, 나이제한 
	
	 //Menu 
   public void mainMenu() {
		boolean check = true;
	    while (check) {	
	    	System.out.println("이름을 입력해 주세요.");
			 String name = sc.nextLine();
			System.out.println("나이를 입력해 주세요.");
			 int age = Integer.parseInt(sc.nextLine());
	     boolean isDuplicate = false;
		 for (Member member : members) {
		 if (member.getName().equals(name)) {
			 isDuplicate = true;
		                break;
		     }
	        }
		   if (isDuplicate) {
	            System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");
	            continue; // 다시 이름 입력으로 돌아감
	        }
		System.out.println("====메뉴====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 로그아웃");
		System.out.println("4. 프로그램 종료");
		try {
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
			    registerAndLogin();
				break;
			case 2:
				 borrowbook();
				break;
			case 3:
				logout();
				break;
			case 4:
				System.out.println("프로그램 종료");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
	     	}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
	    }
	}
   
  }
