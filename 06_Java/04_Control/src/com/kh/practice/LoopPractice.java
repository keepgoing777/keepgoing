package com.kh.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.kh.practice.view.RockPaperScissorView;

class LoopPractice {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
		//l.method1();
		//l.method2();
		//l.method3();
		//l.method4();
		//l.method5();
		//l.method6();
		l.method7();

	}

	/*
	 * 사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오. 사용자 입력 : 5 5 4 3 2 1
	 */
	public void method1() {
		System.out.print("1~100 중 하나의 숫자를 입력하세요 > ");
		int num = sc.nextInt();

		for (int i = num; i >= 1; i--) {
			System.out.println(i);
		}

	}

	// 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.

	public void method2() {
		int sum = 0;
		int n = 0;
		while (sum < 100) {
			n++;
			if (n % 2 == 1) {
				sum += n;
			} else {
				sum -= n;
			}
			if (sum >= 100) {
				System.out.println(n + "까지 더해야 총합이 100 이상이 됩니다.");
				System.out.println("최종 합계: " + sum);
				break;
			}

		}
	}

	/*
	 * 사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요.
	 * 
	 * 문자열 : banana 문자 : a banana 안에 포함된 a 개수 : 3
	 * 
	 */
	/*
	 * public void method3() {
      System.out.println("문자열을 입력하세요"); String word =
	 * sc.nextLine(); System.out.println("문자를 입력하세요"); String spell = sc.nextLine();
	 * 
	 * int count = 0; for (int i = 0; i < word.length(); i++) { if (word.charAt(i)
	 * == spell.charAt(0)) { count++; } }
	 * 
	 * System.out.println(word + " 안에 포함된 " + spell + " 개수 : " + count);
	 */

	public void method3() {
		System.out.print("문자열을 입력하세요");
		String str = sc.nextLine();
		System.out.print("문자를 입력하세요");
		char ch = sc.nextLine().charAt(0);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}
		System.out.println(str + "안에 포함된" + ch + " 개수 :" + count);
	}

	/*
	 * 0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10) 7 3 4 2 3 4 0
	 */

	Random random = new Random();

	public void method4() {
		while (true) {
			int random = (int) (Math.random() * 11);
			System.out.println(random);
			if (random == 0)
				break;
		}
	}

	/*
	 * 주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)
	 * 
	 * 1 : 3 2 : 2 3 : 1 4 : 0 5 : 4 6 : 0
	 */

	public void method5() {
		int[] dice = new int[6];
		for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * 6); // 1-6 > 0-5 범위 변경(인덱스화)
			dice[random]++;
		}

		for (int i = 9; i < dice.length; i++) {
			System.out.println((i + 1) + ":" + dice[i]);
		}
	}

	/*
	 * int dice1 = 0; int dice2 = 0; int dice3 = 0; int dice4 = 0; int dice5 = 0;
	 * int dice6 = 0;
	 * 
	 * for(int i = 0; i < 10; i++) { int random = ((int)Math.random()*6 + 1);
	 * System.out.println(random);
	 * 
	 * switch(random) { case 1: dice1++; breal; case 2; dice2++; breal; case:3;
	 * dice3++; breal; case:4; dice4++; breal; case:5; dice5++; breal; case:6;
	 * dice6++; breal;
	 * 
	 * }
	 */
	/*
	 * 사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고,
	 * 사용자에게는 직접 가위바위보를 받으세요. 사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.
	 * 
	 * 당신의 이름을 입력해주세요 : 김미경 가위바위보 : 가위 컴퓨터 : 가위 김미경 : 가위 비겼습니다.
	 * 
	 * 가위바위보 : 가위 컴퓨터 : 바위 김미경 : 가위 졌습니다 ㅠㅠ
	 * 
	 * 가위바위보 : 보 컴퓨터 : 바위 김미경 : 보 이겼습니다 ! 비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
	 */
	public void method6() {
		int win = 0;
		int lose = 0;
		int draw = 0;

		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();

		while (true) {
			System.out.print("가위바위보 : ");
			String input = sc.nextLine();

			// 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보
			int computer = (int) (Math.random() * 3);
			String computerName = "";
			switch (computer) {
			case 0:
				computerName = "가위";
				break;
			case 1:
				computerName = "바위";
				break;
			case 2:
				computerName = "보";
				break;
			}
			System.out.println("컴퓨터 : " + computerName);
			System.out.println(name + " : " + input);

			if (input.equals(computerName)) { // 비겼을 경우
				System.out.println("비겼습니다.");
				draw++;
			} else if (input.equals("가위") && computerName.equals("보") || input.equals("바위") && computerName.equals("가위")
					|| input.equals("보") && computerName.equals("바위")) { // 이겼을 경우
				System.out.println("이겼습니다!!");
				win++;
				System.out.println("비긴 횟수 : " + draw + ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win);
				break;
			} else { // 졌을 경우
				System.out.println("졌습니다 ㅠㅠ");
				lose++;
			}
		}
	}
	
	/*
	 * public void method6() { int win = 0; int lose = 0; int draw = 0;
	 * 
	 * System.out.print("당신의 이름을 입력해주세요 : "); String name = sc.nextLine();
	 * 
	 * while(true) { System.out.print("가위바위보 : "); String input = sc.nextLine(); int
	 * inputResult = 3; switch(input) { case "가위" : inputResult = 0; break; case
	 * "바위" : inputResult = 1; break; case "보" : inputResult = 2; break; }
	 * 
	 * // 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보 int computer = (int)(Math.random() * 3);
	 * String computerName = ""; switch(computer) { case 0: computerName = "가위";
	 * break; case 1: computerName = "바위"; break; case 2: computerName = "보"; break;
	 * } System.out.println("컴퓨터 : " + computerName); System.out.println(name +
	 * " : " + input);
	 * 
	 * 
	 * if(inputResult == computer) { // 비겼을 경우 System.out.println("비겼습니다."); draw++;
	 * } else if( inputResult == 0 && computer == 2 || inputResult == 1 && computer
	 * == 0 || inputResult == 2 && computer == 1 ) { // 이겼을 경우
	 * System.out.println("이겼습니다!!"); win++; System.out.println("비긴 횟수 : " + draw +
	 * ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win); break; } else { // 졌을 경우
	 * System.out.println("졌습니다 ㅠㅠ"); lose++; } }
	 * 
	 * }
	 */

	/*
	 * public void method6() { // 가위 : 0, 바위 : 1, 보 : 2 String[] rps = {"가위", "바위",
	 * "보"}; int win = 0; int lose = 0; int draw = 0;
	 * 
	 * System.out.print("당신의 이름을 입력해주세요 : "); String name = sc.nextLine();
	 * 
	 * while(true) { System.out.print("가위바위보 : "); String input = sc.nextLine();
	 * 
	 * // 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보 int computer = (int)(Math.random() * 3);
	 * 
	 * // 컴퓨터는 인덱스로 값을 찾음! System.out.println("컴퓨터 : " + rps[computer]);
	 * 
	 * System.out.println(name + " : " + input);
	 * 
	 * // 사용자는 값으로 인덱스를 찾으면 어떨까? // 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로! int
	 * inputResult = Arrays.asList(rps).indexOf(input);
	 * 
	 * if(inputResult == computer) { // 비겼을 경우 System.out.println("비겼습니다."); draw++;
	 * } else if( inputResult == 0 && computer == 2 || inputResult == 1 && computer
	 * == 0 || inputResult == 2 && computer == 1 ) { // 이겼을 경우
	 * System.out.println("이겼습니다!!"); win++; System.out.println("비긴 횟수 : " + draw +
	 * ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win); break; } else { // 졌을 경우
	 * System.out.println("졌습니다 ㅠㅠ"); lose++; } }
	 * 
	 * }
	 */
	/*
	 * public void method6() 
	 * { RockPaperScissor rpsModel = new RockPaperScissor();
	 * String[] rps = rpsModel.rps; int win = 0; int lose = 0; int draw = 0;
	 * 
	 * System.out.print("당신의 이름을 입력해주세요 : "); String name = sc.nextLine();
	 * 
	 * while(true) { System.out.print("가위바위보 : "); String input = sc.nextLine();
	 * 
	 * // 컴퓨터 - 0 : 가위, 1 : 바위, 2 : 보 int computer = (int)(Math.random() * 3);
	 * 
	 * // 컴퓨터는 인덱스로 값을 찾음! System.out.println("컴퓨터 : " + rps[computer]);
	 * 
	 * System.out.println(name + " : " + input);
	 * 
	 * // 사용자는 값으로 인덱스를 찾으면 어떨까? // 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로! int
	 * inputResult = Arrays.asList(rps).indexOf(input);
	 * 
	 * if(inputResult == computer) { // 비겼을 경우 System.out.println("비겼습니다."); draw++;
	 * } else if( inputResult == 0 && computer == 2 || inputResult == 1 && computer
	 * == 0 || inputResult == 2 && computer == 1 ) { // 이겼을 경우
	 * System.out.println("이겼습니다!!"); win++; System.out.println("비긴 횟수 : " + draw +
	 * ", 진 횟수 : " + lose + ", 이긴 횟수 : " + win); break; } else { // 졌을 경우
	 * System.out.println("졌습니다 ㅠㅠ"); lose++; } }
	 */
	
	
	  public void method7() {
		  RockPaperScissorView view = new RockPaperScissorView();
		  view.gameStart();
	  }
}