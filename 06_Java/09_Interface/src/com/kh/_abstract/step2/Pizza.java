package com.kh._abstract.step2;

public abstract class Pizza {
	
 protected int price;
 protected String brand;
 
 
 public Pizza(int price, String brand) {
	this.price = price;
	this.brand = brand;
 }
 
 public abstract void rule();
  
 public abstract void info();

 
 
 
 
}
