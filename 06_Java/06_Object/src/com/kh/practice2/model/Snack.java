package com.kh.practice2.model;

public class Snack {
	
	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
	//기본 생성자
    public Snack(){}
	
    //매개변수 있는 생성자
	public Snack (String kind, String name, String flavor, int numOf, int price){}

	

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	};
	
	
	
	
	
}

