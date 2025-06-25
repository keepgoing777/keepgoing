package com.kh.exception;

import java.io.IOException;

public class B_Throws {
/*
 * 형태 :
 * 리턴타입 메서드명(파라미터,...) throws 예외 클래스, ... { 
 * 
 * }
 * - main 메서드에서 throws 키워드로 예외를 떠넘길 수 있지만 결국 JVM이 예외처리 하게되므로 비추천!
 *   -> 프로그램이 알 수 없는 예외 내용을 출력하고 종료하는 것은 좋지 않음 
 */
	
	
 public static void main(String[] args) {
	 try {
     findClass();
  } catch (ClassNotFoundException e) {
	 // e.printStackTrace();
	 // System.out.println(e.getMessage()) ;
	  System.out.println("클래스가 존재하지 않습니다.");
    }
	 
	  B_Throws b = new B_Throws();
	   try {
		b.method1();
	} catch (ClassNotFoundException | IOException e) {
		//e.printStackTrace(); 빨간줄 보기 싫다면 주석걸고 설명 출력
		  System.out.println("예외가 발생했습니다! ");
	}
	   //웬만하면 여기에서는 Throws 하지 말것 (JVM이 처리하기때문에)
	   //surround with try/multi-catch 
	   //surround with try/catch 
 }
   
  public static void findClass() throws
		  ClassNotFoundException {
	     Class.forName("java.lang.String2");
	  }
	  
  
  public void method1() throws ClassNotFoundException, IOException {
	  System.out.println("method1 호출");
	  method2();
	  System.out.println("method1 종료");
  }
  
  
  
  public void method2() throws ClassNotFoundException, IOException {
	  System.out.println("method2 호출");
	  method3();
	  System.out.println("method2 종료");
  }
  
  
  
  public void method3() throws ClassNotFoundException, IOException {
	  System.out.println("method3 호출");
	  int random = (int)(Math.random()*3 + 1);
	  if(random == 1) {
		  throw new ClassNotFoundException();
	  }else if(random == 2) {
		  throw new IOException();
	  }
	  System.out.println("method3 종료");
  }
  
  
  
  
}