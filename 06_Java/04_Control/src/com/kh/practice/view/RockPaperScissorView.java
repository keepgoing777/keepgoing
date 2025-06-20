package com.kh.practice.view;

import java.util.Scanner;

import com.kh.practice.controller.RockPaperScissorController;

public class RockPaperScissorView {

	RockPaperScissorController controller = new RockPaperScissorController();
	Scanner sc = new Scanner(System.in);

	public void gameStart() {
		System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		
    		// 컴퓨터는 인덱스로 값을 찾음!
    		System.out.println("컴퓨터 : " + controller.randomComputer());
    		
    		System.out.println(name + " : " + input);
    		
    		int result = controller.rpsGame(input);
    		
    		if(result == 1) { // 비겼을 경우
    			System.out.println("비겼습니다.");
    		} else if(result == 2) { // 이겼을 경우
    			System.out.println("이겼습니다!!");
    			System.out.println(controller.rpsResult());
    			break;
    		} else if(result == 3) { // 졌을 경우
    			System.out.println("졌습니다 ㅠㅠ");
    		}
    	}

	}

}
