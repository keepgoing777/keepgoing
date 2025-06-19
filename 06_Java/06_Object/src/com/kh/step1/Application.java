package com.kh.step1;

import com.kh.step1.model.Tv;

public class Application { // 메인 실행 클래스 (객체 생성 및 테스트) 

	/*
	 * 객체(Object) 
	 *  - 현실 세계의 실제로 존재하는 사물이나 개념을 코드로 표현하는 것
	 *  
	 * 객체 지향 프로그래밍(OOP; Objected-Oriented Programming)
	 *  - 개발하는 방법을 여러 개의 "객체"로 나누어 각 객체마다 각자의 역할을 가지도록 구성
	 *  - 코드의 재사용성이 높고, 유지보수가 용이하고, 확장성이 뛰어남
	 *  
	 *  OOP 특징 : 
	 *  1. 추상화(Abstraction)
	 *  2. 캡슐화(Encapsulation)
	 *  3. 상속(Inheritance)
	 *  4. 다형성(Polymorphism) 
	 *  
	 *  OOP 원칙 :
	 *  S : SRP(Single Responsibility Principle) - 단일 책임 원칙
	 *  O : OCP(Open/Closed Principle) - 개방 폐쇄 원칙
	 *  L : LSP(Liskoc Substitution Principle) - 리스코프 치환 원칙
	 *  I : ISP(Interface Segregation Principle) - 인터페이스 분리 원칙
	 *  D : DIP(Dependency Inversion Principle) - 의존 역전 원칙
	 *  
	 *  클래스(Class)
	 *   - 객체를 만들기 위한 설계도
	 *   - 속성(Variable, 변수)+ 기능(Method, 함수)
	 * */
	public static void main(String[] args) {
    /*
     * 객체 생성 
     * 
     * 클래스명 변수명 = new 클래스명();
     *  - new 연산자를 사용해서 생성 (무조건)
     *  - new 연산자는 Heap 영역에 객체를 생성하고 객체의 주소값만 반환함
     *  - 객체의 주소값을 참조 타입의 변수에 저장해서 객체 사용  
     * 
     */
        // 객체 생성함 (import 완료) = 메모리에 올린다 = 객체에 구성요소(field, method)가 다 올라간다.
		Tv tv = new Tv();
		System.out.println("TV 상태 : " + tv.power); //false - TV가 꺼진 상태
		tv.power(); // TV 켜기
		System.out.println("TV 상태 : " + tv.power);
		System.out.println("TV 상태 : " + tv.channel); // 0
		tv.channelUp();
		tv.channelUp();
		tv.channelUp();
		tv.channelDown();
		tv.channelUp();
		tv.channelDown();
		tv.channelDown();
		tv.channelUp();
		tv.channelUp();
		tv.channelDown();
		System.out.println("TV 상태 : " + tv.channel); // 2

		


	}

}
