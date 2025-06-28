package com.kh.practice;
/*
 * controller 분리
 * 1. 수정 -> 메서드 3개?(서버에 저장) 아님 1개 가능?(클라이언트에 저장) - 둘다 가능
 * 2. 유저 정보 한명? 여러명? (배열 3명, 어려우면 PASS)
 * 3. 부서 코드 부서명 등
 * */

import java.time.LocalDate;
import java.util.Scanner;

import com.kh.practice.controller.UserController;
import com.kh.practice.model.Department;
import com.kh.practice.model.UserInfo;

public class Application {

	Scanner sc = new Scanner(System.in);
	UserInfo u = new UserInfo();
    UserController uc = new UserController();
    
    
	public static void main(String[] args) {

		Application app = new Application();
		boolean check = true;
		while (check) {
			int select = app.employeeMenu();
			switch (select) {
			case 1:
				app.insertEmp();
				break;
			case 2:
				app.updateEmp();
				break;
			case 3:
				app.printEmp();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
			}
		}
	}

	// 메인 메뉴를 출력하는 메서드
	public int employeeMenu() {
		System.out.println("1. 직원 정보 추가");
		System.out.println("2. 직원 정보 수정");
		System.out.println("3. 직원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {

		System.out.print("직원 번호 : ");
		int userNo = Integer.parseInt(sc.nextLine());
		System.out.print("직원 아이디 : ");
		String id = sc.nextLine();
		System.out.print("직원 비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("직원 이메일 : ");
		String email = sc.nextLine();
		System.out.print("직원 이름 : ");
		String name = sc.nextLine();
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		// String info = sc.nextLine();
		char add = sc.nextLine().charAt(0);
		if (add == 'y') {
			System.out.print("직원 전화번호 : ");
			String phone = sc.nextLine();
			System.out.print("직원 주소 : ");
			String addr = sc.nextLine();
			System.out.print("직원 성별 : ");
			String gender = sc.nextLine();
		    System.out.print("직원 생일 (예 : 2025-06-23) : "); // LocalDate.parse(문자열) <-문자열을 날짜로 
			LocalDate birthDate = LocalDate.parse(sc.nextLine());
		    System.out.print("부서 코드 : "); // 너무 어렵다면 생략!
		  //String deptName = sc.nextLine();
			int deptNo = Integer.parseInt(sc.nextLine());
		   //Department department = new Department();
		   //department.setDeptName(deptName);
           //추가정보
		  uc.addUser(phone, addr, gender, birthDate, deptNo);
		  }
		  //기본정보
          uc.addUser(userNo, id, password, email, name);
         }

	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("수정하려면 로그인이 필요합니다.");
		// 로그인 기능 필요
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();   		
		System.out.print("비밀번호 입력 : ");
		String password = sc.nextLine();
		// 아이디랑 비밀번호가 틀리다면!
		// 로그인! 클라이언트(화면) 단에도 유저 정보 임시 저장
		u = uc.login(id, password);		
		if(u== null) {
		 System.out.println("로그인 실패! 정보 수정할 수 없습니다");
		 return; // 다음 1.전화번호까지 가지 않도록 
		}				
		System.out.println("직원의 어떤 정보를 수정하시겠습니까?");
		/*if (!id1.equals(u.getId()) || !password1.equals(u.getPassword())) {
			System.out.println("로그인 실패! 정보 수정할 수 없습니다");
		}
		if (id1.equals(u.getId()) && password1.equals(u.getPassword())) {
		
		}*/
		System.out.println("1. 전화 번호");
		System.out.println("2. 생일");
		System.out.println("3. 부서");
		System.out.println("9. 돌아가기");

		System.out.print("메뉴 번호를 누르세요 : ");
		int select = Integer.parseInt(sc.nextLine());

		switch (select) {
		case 1:
			System.out.print("전화 번호 입력 : ");
			String phone = sc.nextLine();
			u.setPhone(phone);
			break;
		case 2:
			System.out.print("생일 입력 (예 : 2025-06-23) : ");
			LocalDate birthDate = LocalDate.parse(sc.nextLine());
			u.setBirthDate(birthDate);
			break;
		case 3:
			System.out.print("부서명 입력 : ");
			String deptName = sc.nextLine();
			Department department = new Department(); 
		    department.setDeptName(deptName);
			u.setDepartment(department);
			break;
		case 9:
			break;
		}
		
		uc.updateUser(u);
	}

	// 데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println(u);
	}
}