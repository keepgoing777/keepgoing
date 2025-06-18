package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
/*
 *  논리 연산자 
 *   - 두개의 논리값을 연산해주는 연산자 
 *   - 논리연산한 결과마저 논리값 
 *   
 *   논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘다 true일 경우만 결과값이 true
 *   논리값 || 논리값 (or) : 왼쪽, 오른쪽 둘 중에 하나라도 true일 경우 결과값이 true
 * */
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
      E_Logical e = new E_Logical();
     // e.method1();
     // e.method2();
        e.practice();
	}
 
	public void method1() {
      // 사용자가 입력한 정수값이 1부터 100사이의 값인지 확인
		System.out.print("정수값 입력 > ");
		int number = sc.nextInt();		
		boolean result = 1 <= number && number <=100;
		System.out.println(1 <= number && number <=100);
   }
	
	
	public void method2() {
		int number = 10;
		boolean result = false;
		// Short Cut Evaluation 
		// true && true = true 
		// true && false = false
		// false && true = false 뒷 계산 안함
		// false && false = false  뒷 계산 안함 
		// && 연산자를 기준으로 앞에서 이미 false이면 굳이 뒤쪽 연산 수행하지 않는다.
 		 result = (number < 5) && (++number > 0); 
		 System.out.println(result); //false
		 System.out.println(number); //10 
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		// || 연산자를 기준으로 앞에서 이미 true이면 굳이 뒤쪽 연산 수행하지 않는다. 
		 result = (number < 20) || (++number > 0);
	     System.out.println(result); // true
		 System.out.println(number); //10 
	}
	// A-Z 65-90 a-z 97-122
	public void practice() {
	  System.out.println("문자 입력해주세요 > ");
	  char ch = sc.nextLine().charAt(0);
	  boolean result = (65 <= ch && ch <= 90) ||  (97 <= ch && ch <= 122);	  
	  result = ('A' <= ch && ch <= 'Z') ||  ('a' <= ch && ch <= 'z');
	  System.out.println("알파벳인가?"+ result);
	 
	}
}





