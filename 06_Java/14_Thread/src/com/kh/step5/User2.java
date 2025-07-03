package com.kh.step5;

public class User2 extends Thread {

	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		setName("Calculator User 2");
		this.calculator = calculator;
	}
	
	public void run() {
		calculator.setMemory(50);
	}
}