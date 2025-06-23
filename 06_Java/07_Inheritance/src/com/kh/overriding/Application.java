package com.kh.overriding;

import java.util.Scanner;

import com.kh.inheritance.model.parent.Product;
import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VipCustomer;

public class Application {

/*
 * SOLID 의 O 
 * Open/Closed Princlple (개방-폐쇄 원칙)
 *  - 기존 코드를 변경하지 않고 확장 가능하게
 * 
 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("일반 회원 or VIP 둘 중 하나 선택 : ");
		String grade = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();		
		
		Customer customer5 = new Customer(name);
		
		if(grade.equals("VIP")) {
		 VipCustomer vipCustomer = new VipCustomer(name);
		 vipCustomer.calc(price);
		 System.out.println(vipCustomer);
		} else {
			customer5.calc(price);
			System.out.println(customer5);
		}
		
		Product product = new Product();
		product.setBrand("LG");
		System.out.print(customer5.getProduct().getBrand());
		
		customer5.setProduct(new Product());
		customer5.getProduct().getBrand();
		
	/*	int price = 100000;  
	    
		Customer customer1 = new Customer("서지은");
		customer1.calc(price); // calc 에 대한 매서드(함수)는 부모클래스에서 부여(Customer)
	
		VipCustomer customer2 = new VipCustomer("김은진");
		customer2.calc(price); 
		
	    Customer customer3 = new Customer("서지은");
	    VipCustomer customer4 = new VipCustomer("김은진");
	    
	    System.out.println(customer1.equals(customer3));
	    System.out.println(customer2.equals(customer4));
	    
	*/
		/*
			    System.out.println((customer1.getName() + "님의 등급은 " + customer1.getGrade()+ "이며, 지불해야하는 금액은 " 
		                            + price + "원이며, 적립된 포인트는 " + customer1.getBonusPoint() + "점 입니다."));
				System.out.println((customer2.getName() + "님의 등급은 " + customer2.getGrade() + "이며, 지불해야하는 금액은 " 
			    + price*customer2.getSaleRatio() + "원이며, 적립된 포인트는 " + customer2.getBonusPoint() + "점 입니다."));
	}
	
*/
	//100000	
	//~~님의 등급은 ~~이며, 지불해야하는 금액은 ~원이며, 적립된 포인트는 ~~점입니다. 	
  }
	
	
}
	
	

