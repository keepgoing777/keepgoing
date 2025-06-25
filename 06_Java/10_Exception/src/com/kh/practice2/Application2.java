package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.MemberController;
import com.kh.practice2.exception.DuplicateIdException;
import com.kh.practice2.exception.RecordNotFoundException;
import com.kh.practice2.model.Member;

public class Application2 {

	Scanner sc = new Scanner(System.in);
	Member[] members = new Member[3];
	MemberController mc = new MemberController();

	public static void main(String[] args) {
		Application2 app = new Application2();
		app.mainMenu();

	}

	public void mainMenu() {
		boolean check = true;
		while (check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.count + "명입니다.");
			// 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께
			// '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리!
			if (mc.count < 3) {
				System.out.println("1. 새 회원 등록");
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
			}
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			try {
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				insertMember();
				break;
			case 2:
				updateMember();
				break;
			case 3:
				printAll();
				break;
			case 9:
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

	// 1번
	public void insertMember() {
		Member m = new Member();
		System.out.println("아이디 : ");
		m.setId(sc.nextLine());
		
		try {
			boolean idCheck = mc.idCheck(m.getId()) == -1;
			if (idCheck) {
				System.out.println("이름 : ");
				m.setName(sc.nextLine());
				System.out.println("비밀번호 : ");
				m.setPwd(sc.nextLine());
				System.out.println("이메일: ");
				m.setEmail(sc.nextLine());
				System.out.println("성별(M/F) : ");
				m.setGender(sc.nextLine());
				System.out.println("나이 : ");
				m.setAge(Integer.parseInt(sc.nextLine()));
		     	mc.addInfo(m);	 //추가로직 와야하는부분
			}
		}catch(DuplicateIdException e) {
		    e.printStackTrace();
		    System.out.println(e.getMessage());
		    insertMember();
		}
		
	}

	// 2번
	public void updateMember() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();

		try {
			boolean idCheck = mc.updateCheck(id) == -1;
			if (idCheck) {
				System.out.println("회원 정보가 없습니다.");
			} else {
				System.out.print("수정할 이름 : ");
				String name = sc.nextLine();
				System.out.print("수정할 이메일 : ");
				String email = sc.nextLine();
				System.out.print("수정할 비밀번호 : ");
				String pwd = sc.nextLine();

				mc.updateInfo(id, name, email, pwd);
			}
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
			updateMember();
		}
	
	}

	// 3번
	public void printAll() {
		for (Member member : mc.getMembers()) {
			if (member != null) {
				System.out.println(member);
			}
		}
	}

	// equals(m.getId()) 와 equals(id)만 다름
	/*
	 * boolean idUpdate = true; for(Member member : members) { //일치한 경우가 있으면 존재한다!
	 * if(member!=null && member.getId().equals(id)) { idUpdate = false; } }
	 */

}
