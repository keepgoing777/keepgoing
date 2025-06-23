package com.kh.inheritance.model.parent;
/*
 * 모든 클래스는 Object 클래스의 후손
 * 즉, 최상위 클래스는 항상 Object 
 * Object 클래스에 있는 모든 메서드를 사용할 수 있다.
 * 
 * */
public class Product extends Object {
	
	public String brand;
	String pCode;
	protected String name;
	private int price;
	
	public Product() {}
		
	
	public Product(String brand, String pCode, String name, int price) {
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [brand=" + brand + ", pCode=" + pCode + ", name=" + name + ", price=" + price + "]";
	}

	
	 
	

}
