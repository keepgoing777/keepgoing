package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {

	public BulgogiPizza(int price, String brand) {
		super(price, brand);
	}

	public void rule() {
		System.out.println(
				"해당 " + brand + " 의 불고기피자 가격은 " + price + " 원입니다.\n" 
	            + "피자 반죽과 함께 도우를 빚는다.\n"
				+ "토핑은 불고기를 포함한다\n" 
	            + "피자를 180도에서 10분간 구운다.\n" 
				+ "피자를 8등분 한다.\n" 
	            + "피자를 포장한다.\n ");
	}

	@Override
	public void info() {
		System.out.println(this.brand+ "의 불고기 피자 가격은 " + this.price + "원 입니다.");
	}

}
