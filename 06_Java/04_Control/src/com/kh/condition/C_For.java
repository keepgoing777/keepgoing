package com.kh.condition;

import java.util.Random;
import java.util.Scanner;

public class C_For {

	Scanner sc = new Scanner(System.in);
	/*
	 * for 문
	 * 
	 * for (초기식; 조건식; 증감식 { 실행코드 }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문 
	 * - 초기식 : 반복문이 수행될 때 단 한번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값 대입 
	 * - 조건식 : 결과가 true이면 실행 코드를 실행, false 이면 실행하지 않고 반복문을 빠져나감 
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	 * 
	 * continue 문 - continue문은 반복문 안에서 사용 - 반복문 안에서 continue를 만나면 "현재 구문" 종료 - 반복문을
	 * 빠져나가는 것
	 */

	public static void main(String[] args) {
		C_For c = new C_For();
		// c.method1();
		// c.method2();
		// c.method3();
	    // c.method4();
		// c.method5();
		 c.method6();
		// c.method7();
		// c.method8();
	    // c.method8();
		// c.method9();
		 //c.method10();
		 //c.method11();

	}

	// 1,2,3,4,5 출력
	public void method1() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	// 반대로 출력
	public void method2() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}

	// 1~10까지 홀수만 출력
	public void method3() {
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0)
				System.out.println(i);
		}
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0)
				continue;
			System.out.println(i);
		}
	}

	// 1~10까지 합계
	// 1부터 입력받은 값까지 합계

	public void method4() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}	System.out.println(sum);
	}	
	
	public void method5() {
		int sum = 0;
		System.out.println("숫자를 입력해주세요");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++) {
		    sum += i;
		}   System.out.println(sum);	
	}	
	
	// 1부터 랜덤값 까지 합계 (double random = Math.random(); 0.0 <= random < 1.0)
	public void method6() {
		int random = (int) (Math.random() * 9 + 2); // 0.0 <= random < 1.0, 2에서부터 11까지
	//	Random random2 = new Random(); // import 해야함(utility인 경우)  
	//	int random3 = random2.nextInt(9) + 2 ; //정수값을 랜덤으로 받는 메서드 (2~11 10개 줌) 
	//	int random4 = random2.nextInt(2, 11);
		
		int sum = 0;
		for (int i = 1; i <= random; i++) {
			 sum += i;
		} System.out.println(sum);
		  System.out.println(random); 
	}
	
	//영문자 쪼개기 tomato = t o m a t o
	public void method7() {
		System.out.println("문자를 입력해주세요");
		String word = sc.nextLine(); 
       for(int i = 0; i < word.length(); i++) {
       System.out.println(word.charAt(i));
       }
		/* 향상된 for문
		 *  for(데이터 타입 변수 : 배열) {
		 *   변수 : 배열의 값을 하나씩 가지고 옴 
		 *  }
		 *  문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열 
		 *   - toCharArray : 모든 문자가 들어있는 char[] 형식의 데이터 반환
		 *   - charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환 
	     */
        char[] arr = word.toCharArray();
	    for(char ch : word.toCharArray()) {
    	   System.out.println(ch);
        }	   
      }
/*
//*****
//*****
//*****
//*****
 */
	public void method8() {
		for(int j = 0; j < 4; j++) {
	    	for(int i = 0; i < 5; i++) {
			System.out.print("*");
		} System.out.println();
	  }
	}
/*		
//1*****
//**2***
//***3**
//****4*
//*****5
*/
	
	public void method9() {
      for(int i = 1; i <= 5; i++) {
    	  for(int j = 1; j <= 5; j++) {
    	   // System.out.print("("+ i + "," + j + ")");
    	   if(i==j) System.out.print(i);
    	   else System.out.print("*");
      }  System.out.println();
	}
   }
/*
// *     i=0 j=0
// **    i=1 j=0,1
// ***   i=2 j=0,1,2
// ****  i=3 j=0,1,2,3
 * ***** i=4 j=0,1,2,3,4
 * */
	public void method10() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				if(i>=j) 
					System.out.print("*");
				else System.out.print(" ");
			} System.out.println();
		}		
	}
	
	/*
	 *     * i=0 j=4
	 *    ** i=1 j=3,4
	 *   *** i=2 j=2,3,4
	 *  **** i=3 j=1,2,3,4
	 * ***** i=4 j=0,1,2,3,4
	 * */
	
	
	public void method11() {
		for(int i = 0; i < 5; i++) {
			for(int j = 4; j >= 0; j--) {
			   if(i < j) System.out.print(" ");
			   else System.out.print("*");
			} System.out.println();
		}
	}
	
	
}