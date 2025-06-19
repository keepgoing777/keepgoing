package com.kh.condition;

import java.util.Random;
import java.util.Scanner;

public class D_While {
/*
 * While문
 * 
 * While(조건식) {
 *  조건이 true일 경우 계속 실행
 *  }
 * */

	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
       D_While d = new D_While();
       d.method1();
       d.method2();
       d.method3();
       d.method4();
       d.method5();
       d.method6();
	}

	public void method1() {
	 int i=1;
	 while(i<=5) {
		 System.out.println(i);
		 i++;
	 }
	}
/*
 * 무한 루프 & break문
 *  - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용 
 *  - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠2져나간다
 * */	
	public void method2() {
	 while(true) {
		 System.out.print("숫자 입력 > ");
		 int num = sc.nextInt();
		 System.out.println(num);
	 if(num==0) break;
	 }
	}

/*
 * do{
 *   실행코드
 * } while(조건식);
 * 
 * - 조건과 상관없이 무조건 한번은 실행함
 * */
	
	public void method3() {
	 int number = 1; 
	 while(number==0)
		 System.out.println("while");
	 
	 do {
		 System.out.println("do-while");
	 } while(number==0);
	}
	
/*
 *숫자 맞히기 게임
 *1과 100사이의 값 중에 정답을 저희가 정하고 
 *컴퓨터(random)가 맞히도록! 몇 번만에 끝내는지 출력!
 *해당 숫자보다 정답이 높으면 up! 낮으면 down!
 * */
	
	public void method4() {
		System.out.print("숫자를 입력해주세요 > ");
		int number = sc.nextInt();
		int min = 1;
		int max = 100;
		int count = 0;
		while(true) {
		++count;
	    int random = (int)(Math.random()*(max-min+1)+min);
        if(number > random) {System.out.println(random + ", Up!");
         min = random + 1; }
        else if(number < random) {System.out.println(random + ", Down!");	
         max = random - 1;}
        else { System.out.println(random + ", 정답!" + count + "회 만에 맞쳤습니다!");
          break;
          }
        }
     }
	
	/*
	 *숫자 맞히기 게임
	 *컴퓨터(random) 1과 100사이의 값 중에 정답을 저희가 정답 맞히도록 몇 번만에 끝내는지 출력!
	 *해당 숫자보다 정답이 높으면 up! 낮으면 down!
	 * */
	
	public void method5() {
		int random = (int)(Math.random()*100+1);
		System.out.println("정답:" + random);
		int count = 0;
		while(true) {
	        count++;
			System.out.print("숫자를 입력해주세요 > ");
			int number = sc.nextInt();
			if (random > number) {
				System.out.println("up!");
			}else if (random < number) {
				System.out.println("down!");
			}else {
				System.out.println("정답!"+ count +"회만에 맞췄습니다!");
				break;
			}
		}
	}
	
/* 1 예금 2 출금 3 잔고 4 종료
 * 선택 1 : 예금액 1000
 * 선택 2 : 출금액 5000
 * 선택 3 : 잔고 확인
 * 선택 4 : 프로그램 종료
 */
	public void method6() {
		int balance = 0;
		boolean check = true;
		while(check) {
			System.out.println("----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			/*
			if(select==1) {
				System.out.print("예금액 > ");
				balance += sc.nextInt();
			} else if(select == 2) {
				System.out.print("출금액 > ");
				balance -= sc.nextInt();
			} else if(select == 3) {
				System.out.println("잔고 확인 > " + balance);
			} else if(select == 4) {
				System.out.println("프로그램 종료");
				break;
			}*/
			
			switch(select) {
				case 1:
					System.out.print("예금액 > ");
					balance += sc.nextInt();
					break;
				case 2:
					System.out.print("출금액 > ");
					balance -= sc.nextInt();
					break;
				case 3:
					System.out.println("잔고 확인 > " + balance);
					break;
				case 4:
					System.out.println("프로그램 종료");
					check = false;
					break;
			      }
			
		     } //if(select == 4) break;
	      }
			

}	