package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {
	/*
	 * 비교 연산자 
	 * a < b : a가 b보다 작은가?
	 * a > b : a가 b보다 큰가?
	 * a <= b : a가 b보다 작거나 같은가?
	 * a >= b : a가 b보다 크거나 같은가?
	 * a == b : a와 b가 같은가?
	 * a != b : a와 b가 같지 않은가?
	 * 
	 * 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false
	 * */

	public static void main(String[] args) {
		D_Comparison d = new D_Comparison();
		//d.method1();
         d.method2();
	}

	public void method1() {
		int a = 10;
		int b = 25;
		System.out.println(a==b);
		System.out.println(a<=b);
		boolean result = a > b ; //결과가 boolean형이면 boolean형으로 담아내면 됨
		System.out.println(result);
		System.out.println((a*2) > (b/5));
		
		//짝수, 홀수 
		//2로 나눠서 나머지가 0인경우 == 짝수 / 나머지가 1인경우 or 나머지가 0이 아닌 경우 == 홀수 
		System.out.println("a가 짝수인가? : " + (a%2==0)); // a=10
		System.out.println("b가 홀수인가? : " + (b%2==1));
		System.out.println("b가 홀수인가? : " + (b%2!=0));
		System.out.println("b가 홀수인가? : " + !(b%2==0));
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력: ");
	    int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력: ");
		int num2 = sc.nextInt();
		//첫번째 수가 두번째 수보다 큽니까?
		System.out.println(num1 > num2);
		//첫번째 수가 짝수입니까?
		System.out.println(num1%2==0);
		//두번째 수가 'A'보다 큽니까?
		System.out.println(num2>'A');
		System.out.println((int)'A'); //A~Z 65~90, a~z 97~122 고정값

	}
}
