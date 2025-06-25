package com.kh.exception;
/*
 * UncheckedException
 *  - RuntimeException을 상속하고 있는 예외들
 *  - 컴파일 시 예외 처리 코드가 있는지 검사하지 않는 예외
 *  - RuntimeException의 경우 프로그램 실행할 때 문제 발생
 *  - 충분히 예측 가능해서 조건문으로도 처리 가능 
 * */

public class C_UncheckedException {

	//ArrayIndexOutOfBoundsException
	//배열의 접근에 잘못된 인덱스 값을 사용하는 경우 
	public void method1() {
	   String[] str = {"Hello Java", "Nice to meet you"};
		try {
	   for(int i = 0; i < 3; i++) {
			System.out.println(str[i]);
	   }
	   } catch(ArrayIndexOutOfBoundsException e){
		   System.out.println(e.getMessage());
	   }
     }
	
	//NegativeArraySizeException
	//배열 크기를 음수로 지정한 경우 
	public void method2() {
		try {
		int[] arr = new int [-3];
		}catch(Exception e){
         System.err.println(e.getMessage());	
         //Sysytem.err.println 붉은색으로 에러 표시 출력
		}
	}
	//NullPointerException
	//null인 참조 변수로 객체의 멤버 변수 참조 시도 시 에러 
	public void method3() {
	try {
	     String str = null;
	     System.out.println(str.length());
	  }catch(Exception e) {
	    System.err.println(e.getMessage());	
	  }finally {
		  System.out.println("예외 발생 여부 상관없이 무조건 실행!");
	  }
	}
	
	public static void main(String[] args) {
	C_UncheckedException c = new C_UncheckedException();
	//c.method1();	
	//c.method2();
	c.method3();
	}
	
	
	
	
	
	
	
	
	
	
}