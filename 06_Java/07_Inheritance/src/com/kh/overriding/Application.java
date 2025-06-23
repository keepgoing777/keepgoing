package com.kh.overriding;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VipCustomer;

public class Application {

	public static void main(String[] args) {
		int price = 100000;
		Customer customer1 = new Customer("서지은");
		customer1.calc(price); // calc 에 대한 매서드(함수)는 부모클래스에서 부여(Customer)
	
		VipCustomer customer2 = new VipCustomer("김은진");
		customer2.calc(price); 
		
	    Customer customer3 = new Customer("서지은");
	    VipCustomer customer4 = new VipCustomer("김은진");
	    
	    System.out.println(customer1.equals(customer3));
	    System.out.println(customer2.equals(customer4));
	    
	    
	    
			    System.out.println((customer1.getName() + "님의 등급은 " + customer1.getGrade()+ "이며, 지불해야하는 금액은 " 
		                            + price + "원이며, 적립된 포인트는" + customer1.getBonusPoint() + "점 입니다."));
				System.out.println((customer2.getName() + "님의 등급은 " + customer2.getGrade() + "이며, 지불해야하는 금액은 " 
			    + price*customer2.getSaleRatio() + "원이며, 적립된 포인트는 " + customer2.getBonusPoint() + "점 입니다."));
	}
	

	//100000
	
	//~~님의 등급은 ~~이며, 지불해야하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다. 	
  }
	
	
	
	

