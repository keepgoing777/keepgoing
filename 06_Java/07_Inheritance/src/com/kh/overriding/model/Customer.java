package com.kh.overriding.model;

import java.util.Objects;

import com.kh.inheritance.model.parent.Product;

/*
 * 클래스 간의 관계 : 상속 vs 포함(포함관계가 실무에서 많이 보게 됨)
 *  - 상속 관계 : ~은 ~이다. (is - a 관계)
 *  - 포함 관계 : MODEL (DB랑 1:1), JOIN (테이블 분리 시 1:M 관계많았음, foreign key 엮는 관계 )
 * */

public class Customer {

	protected String name; //고객 이름 
	protected String grade; // 고객 등급 
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; // 보너너스 적립 비율
	protected int price; //가격
	
	public Customer(String name) {
		this.name = name;
	    this.grade = "SILVER";
	    this.bonusRatio = 0.01;
	}
	
	//포함 관계
	protected Product product;
	
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}




	public Customer() {
	   //  System.out.println("부모생성자!");
	} 


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	
	public Customer(String name, String grade, int bonusPoint, double bonusRatio) {
		this.name = name;
		this.grade = grade;
		this.bonusPoint = bonusPoint;
		this.bonusRatio = bonusRatio;
	}

	public void calc(int price) {
	  this.bonusPoint = (int)(price*bonusRatio);
	  this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
			Customer c = (Customer) obj;
			return c.name == this.name;
	}
	
	
/*	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
				+ bonusRatio + "]";
	}
*/	
	public String toString() {
		return name + "님의 등급은 " + grade + "이며 지불해야하는 금액은 " + price + "이며 적립된 포인트는 " + bonusPoint + " 점 입니다.";
				
	}
	
	

}
