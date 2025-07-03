package com.kh.step5;

public class User1 extends Thread {
	
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		setName("Calculator User 1");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(100);
	}
}