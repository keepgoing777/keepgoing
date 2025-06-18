package com.kh.operator;

public class C_Arithmetic {

	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
		//c.method1();
		c.method2();
    /*
     * 산술 연산자
     *  + : 더하기
     *  - : 빼기
     *  * : 곱하기
     *  / : 나누기
     *  % : 나머지
     */
	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("+ : " + (num1 + num2));
		System.out.println("- : " + (num1 - num2));
		System.out.println("* : " + (num1 * num2));
		System.out.println("/ : " + (num1 / num2)); //정수 나누기 정수 = 정수 
		System.out.println("% : " + (num1 % num2)); 
	}

	public void method2() {
	 int a = 5; 
	 int b = 10;
	 int c = (++a) + b++; // a=6 b=10(b값 11) = 16
	 int d = c / a; // 16/6 = 2
	 int e = c % a; // 16%6 = 4
	 int f = e++; // 4 (f값 5)
	 int g = (--b) + (d--); // 10(b)+2(d 값1) = 12
	 int h = c-- * b;  //16(c값 15) / 10 = 160
	 int i = (a++) + b / (--c / f) * (g-- -d) % (++e + h);
			 // 6 + 10 / (14/4) * (12-1) % (6+160)
	 // i값은 얼마일까요? 
	}
}
