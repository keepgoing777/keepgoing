package com.kh.step2.model;

public class Card {
	
	/*
	 * 변수의 종류
	 * 1. 지역 변수(Local variable)
	 *  - 메서드 내에 선언되며, 메서드 종료와 함께 소멸 
	 *  - 해당 블록이 끝나면 메모리에서 사라짐 
	 *  
	 * 2. 인스턴스(=객체) 변수(Instance variable)
	 *  - 클래스 내에 선언되며, 객체 생성할 때마다 따로 존재
	 *  - 각 객체마다 개별적인 저장 공간 
	 *  - 생성 시 '참조변수.인스턴스변수명'으로 접근
	 *  - 객체가 사라지면 자동으로 소멸 
	 *  
	 * 3. 클래스 변수(Class variable, Static variable)
	 *  - static 키워드가 붙여 선언된 변수 
	 *  - 객체 생성 없이 '클래스이름.변수명'으로 접근 
	 *  - 클래스가 처음 로딩될 때 메모리에 올라가고, 프로그램 종료 시 소멸
	 *  
	 *  
	 *  
	 * 
	 * MVC= Model(tv, card 등 - DB와 1:1 매칭됨)
	 *      View(JSP - 자바코드가 들어간 HTML, 화면) 
	 *      Controller(JSP - 자바코드가 들어간 HTML, 기능 / Servlet)
	 * */
	
	//인스턴스 변수 : 카드마다 다를 수 있는 값 
	public int number; // 숫자
	public String kind; // 모양
	
	//클래스 변수 : 모든 카드가 공유하고 있는 값
 	public static int width; // 가로길이
	public static int height; // 세로길이

}
