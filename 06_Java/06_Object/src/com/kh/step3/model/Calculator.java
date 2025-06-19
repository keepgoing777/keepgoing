package com.kh.step3.model;

public class Calculator {
/*
 * 메서드(method)
 *  - 어떤 기능을 수행하는 명령문의 집합
 *  - 입력값(parameter)을 받아서, 결과값(return)을 돌려줄 수 있음
 *  - 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음
 *  - 하나의 메서드는 한 가지 기능만 수행하도록 작성하는것이 좋음 (SRP원칙 - 단일 책임 원칙) 
 *  - 반환값이 없는 경우 리턴타입이 "void" 
 *  
 *  리턴타입 메서드명(파라미터, ... ) {
 *       실행문;
 *       return 반환값;
 *  }
 *  
 * */
	public int a;
	public int b;
	
	//더하기 
	public int add() {
	 return	a + b;
	} 
	
	//빼기
	public int substract() {
		return a - b;
	}
	
	//곱하기
	public int multiply(int a, int b) {
		return a * b;
	}
	
	//나누기 divide, 몫은 12, 나머지는 3
	public static String divide(int a, int b) {
			return "몫은" + (a / b) + ", 나머지는" + (a % b);
	}

}
