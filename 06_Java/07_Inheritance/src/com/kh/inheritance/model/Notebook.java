package com.kh.inheritance.model;

import com.kh.inheritance.model.parent.Product;

/*
 * 구조 : class 자식 클래스 extends 부모 클래스{}
 * 상속의 장접(저희가 직접 코드로 짜보는건 여기서만!)
 *  - 적은 양의 코드로 새로운 클래스 작성 가능
 *  - 코드를 공통적으로 관리하기 때문에 코드의 추가나 변경에 용이
 *  - 코드의 중복을 제거하여 프로그램 생산성과 유지보수에 크게 기여
 *  
 *  상속의 특징
 *  - 클래스 간의 상속은 단일 상속만 가능하다(단 하나의 클래스로만 부모로 가질 수 있음)
 *  - 명시 되지 않아도 모든 클래스는 Object 클래스 상속
 *   -> Object 클래스의 메서드들을 오버라이딩 하여 메서드 재정의 가능
 *  - 부모 클래스의 생성자, 초기화 블록은 상속되지 않는다
 *   -> 자식 클래스 생성 시 부모 클래스 생성자가 먼저 실행됨
 *  -부모의 private 변수는 상속은 되지만 직접 접근은 불가능
 *   -> Getter / Setter 사용해서 간접 접근 가능
 * */
public class Notebook extends Product{
	
	private String cpu;
	
	public Notebook() {}

	public Notebook(String brand, String pCode, String name, int price, String cpu) {
	// super : 해당 객체의 부모 객체 주소를 담고 있다. 
    // 1. 부모 생성자 호출 

		super(brand, pCode, name, price);
		this.cpu = cpu;
	 // 2. super.을 통해서 부모의 변수에 직접 접근	
		super.brand = brand; //부모가 public이면 어디서든 접근 가능
		//super.pCode = pCode; //부모가 default  - 같은 패키지에 있어야만 사용가능
		super.name = name; //부모가 protected - 상속관계일 때 자식 객체에서 접근가능 (타 패키지에 있어도)
		//super.price = price; // 부모가 private - 직접 접근 X 
	 // 3. 부모의 setter 메서드를 호출해서 초기화
     // - 부모 클래스에서 setter 메서드를 제공하면 자식 클래스에서 부모의 setter 메서드를 통해 초기화 가능

    	//	super.setpCode(pCode); 표현 형태
    	//	this.setName(name);
	   //	setPrice(price);
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

/*
 * 오버라이딩(overriding)
 * - 자식클래스가 상속받은 부모 클래스의 메서드를 재정의하는 것
 * 
 * 
 * */
	@Override
	public String toString() {
		return super.toString() + "Notebook [cpu=" + cpu + "]";
	}
	

}
