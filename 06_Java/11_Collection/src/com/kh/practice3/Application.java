package com.kh.practice3;

import java.util.Scanner;

import com.kh.practice3.controller.MusicController;
import com.kh.practice3.model.Music;

public class Application {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public static void main(String[] args) {
		
		Application app = new Application();
		app.menu();

	}
	
	public void menu() {
		try {
			boolean check = true;
			while(check) {
				System.out.println("===== 메인메뉴 =====");
				System.out.println("1. 특정 곡 추가");
				System.out.println("2. 전체 곡 목록 출력");
				System.out.println("3. 특정 곡 검색");
				System.out.println("4. 특정 곡 수정");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 종료");
				System.out.print("메뉴 번호 입력 : ");
				switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						mc.addList();
						break;
					case 2:
					    mc.printAll();
						break;
					case 3:
						mc.searchMusic();
						break;
					case 4:
						mc.updateMusic();
						break;
					case 5:
						mc.removeMusic();
						break;
					case 6:
						System.out.println("종료");
						check = false;
						break;
					default: 
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				}
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			menu();
		}
	}
	
	public void addList() {
		mc.addList();
	}
	
	//2. 전체 곡 목록 출력
	public void printAll() {
	    mc.printAll();
	}
	
	//3. 특정 곡 검색	
	public void searchMusic() {
		mc.searchMusic();
	}
	
	//4. 특정 곡 수정
	public void updateMusic() {
		mc.updateMusic();
		/*
		 * ****** 특정 곡 수정 ******
		 * 검색할 곡명 : 
		 * 수정할 곡명 : 
		 * 수정할 가수명 : 
		 * 
		 * 수정에 성공한다면 "(바꾸기 전 가수 - 바꾸기 전 곡)의 값이 변경되었습니다."
		 *       실패한다면 "곡을 수정하지 못했습니다."
		 * */
	}
	
	//5. 특정 곡 삭제
	public void removeMusic() {
	    mc.removeMusic();
		
	}

}