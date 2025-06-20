package com.kh.step4;

import com.kh.step4.model.Car;

public class Application {

	public static void main(String[] args) {

		Car car = new Car("red", "auto", 4);
		
	/*	car.color = "red";
		car.gearType = "auto"; 
		car.door = 4;  */
		
		
		Car car2 = new Car("black", "manual");
		
		
		System.out.println(car);
		System.out.println(car2);
	}
	

}

  