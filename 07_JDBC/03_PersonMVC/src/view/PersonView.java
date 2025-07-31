package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import controller.PersonController;
import vo.Person;

public class PersonView {
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonView view = new PersonView();
		view.menu();
		view.addPerson(); 
		view.searchAllPerson();
		view.searchPerson();
		view.updatePerson();
		view.removePerson();
	}

	public void menu() {
		while (true) {
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 아이디 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				System.out.println(addPerson());
				break;
			case 2:
				searchAllPerson();
				break;
			case 3:
				searchPerson();
				break;
			case 4:
				System.out.println(updatePerson());
				break;
			case 5: 
				System.out.println(removePerson()); 
				break;
			}

		}
	}//종료

	public String addPerson()  {
		try {
			System.out.print("이름 > ");
			String name = sc.nextLine();
			System.out.print("나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 > ");
			String addr = sc.nextLine();
			return pc.addPerson(name, age, addr);
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요~~";
		}
	}//종료

	public void searchAllPerson() {
		
			List<vo.Person> list = pc.searchAllPerson();
			if(list!=null) {
			for (Person p : list) {
				System.out.println(p);
			}		
		}
			
	}//종료

	public void searchPerson() {
		searchAllPerson();

		System.out.println("아이디 선택 >");
		int id = Integer.parseInt(sc.nextLine());
		Person person = pc.searchPerson(id);
		System.out.println(person + "이 조회되었습니다!");
		if (person != null)
			System.out.println("아이디가 없습니다..");
	}//종료

	public String updatePerson() {
		searchAllPerson();
		
		System.out.println("아이디 >");
		int id = Integer.parseInt(sc.nextLine());
		Person person = pc.searchPerson(id);
		
		//아이디가 없는 경우 내보내기!
		if(person == null) return "조회된 아이디가 없습니다";
		
		//아이디가 있는 경우만 수정 가능
		System.out.println("이름 >");
		String name = sc.nextLine();
		
		System.out.println("나이 >");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("주소 >");
		String addr = sc.nextLine();

		return pc.updatePerson(name, age, addr, id);
	}//종료
	
	public String removePerson() {
		
			searchAllPerson();
			
			System.out.println("아이디 >");
			int id = Integer.parseInt(sc.nextLine());
			
			Person person = pc.searchPerson(id);
			//아이디가 없는 경우 내보내기!
			if(person == null) return "조회된 아이디가 없습니다";
			//아이디가 있는 경우만 삭제할 수 있도록
		     return pc.removePerson(id);
		
	}//종료 

}//최종종료
