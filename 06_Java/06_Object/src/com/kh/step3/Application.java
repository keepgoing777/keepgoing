package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	//static 클래스, return 값 없음
	public static void main(String[] args) {
/*
 * 변수와 메서드 호출방법
 * 
 * 변수
 * 참조변수.변수명; (c.a, c.b)
 * 클래스명.변수명; //  static 변수 호출
 * 
 * 메서드
 * 참조변수.메서드명();  (c.add();)   - 파라미터(매개변수)가 없는 경우  
 * 참조변수.메서드명(값1, 값2, ...)  c.multiply(,) - 파라미터(매개변수)가 있는 경우 (값을 적어줘야한다)
 * 클래스명.메서드명();  //static 메서드 호출  Calculator.divide(,)
 * 
 * */

		Calculator c = new Calculator();
		
		c.a = 10;
		c.b = 75;
		 
		System.out.println("더하기 : " + c.add());
		System.out.println("빼기 : " + c.substract());
		System.out.println("곱하기 : " + c.multiply(20, 35));
		System.out.println("나누기 : " + Calculator.divide(45, 4));
        System.out.println(c.factorial(5));	
        System.out.println(c.factorial2(6));	

   
	}

}
