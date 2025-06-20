package com.kh.step4.model;

public class Car {
/*
 * 접근 제어자(access modifier), 접근 제한자
 *  - 클래스, 변수, 메서드, 생성자에 사용되어 외부로부터 접근 제한
 *  
 * Public : 접근 제한이 전혀 없음 
 * #protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손 클래스에서 접근 가능
 *   default : 같은 패키지에서만 접근 가능
 * -private : 같은 클래스 내에서만 접근 가능
 * */
	
	protected String color;
	String gearType ;
	private int door ;
	
/*
 * 생성자
 *  - 객체가 생성될 때마다 호출되는 '객체 초기화 메서드'
 *  - 변수의 초기화 또는 객체 생성 시 수행할 작업에 사용
 *  
 *  주의사항
 *  - 반드시 생성자명은 클래스 명과 동일(대/소문자 구분) 무조건 일치
 *  - 반환형이 존재하지 않음 -> 만약 return이 있다면 일반 메서드로 인식
 *  
 *  기본 생성자(default constructor)
 *  - 매개변수가 없는 생성자
 *  - 클래스에 생성자가 하나도 없으면 컴파일러가 기본 생성자를 자동으로 추가
 *  - 생성자가 하나라도 있으면 컴파일러는 기본 생성자를 추가하지 않음
 *   
 * 
 *///오버로딩 : 한 클래스 내에 동일한 이름의 메서드를 파라미터의 자료형과 개수, 순서가 다르게 작성된 경우
   //기본 생성자
    public Car() {}
   
	public Car(String color, String gearType, int door) {
		 this.color = color;
		 this.gearType = gearType;
		 this.door = door;
		 
   // this : 자신을 가르키는 참조변수. 객체주소가 저장되어 있음. 모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재 
	}
 
	public Car(String color, String gearType) {
		this.color = color;
		this.gearType = gearType;		
	}
	
	public void test() {}
	public void test(int a) {}
	public void test(int a, String s) {}
	public void test(String s, int a) {}
	
    //오버라이딩 : 부모 클래스의 메서드를 자식 클래스에서 다시 재정의 
	@Override
	public String toString() {
		return "색상 : " + color + ", 변속기 : " + gearType + ", 문 개수 : " + door;
	}

 
} 